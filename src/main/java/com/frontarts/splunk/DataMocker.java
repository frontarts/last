package com.frontarts.splunk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by wangy23 on 8/6/15.
 */
public class DataMocker {

    private static final int acCategory = 10;
    private static final int electricsCategory = 5;
    private static final int autoCategory = 4;
    private static final int chargeCategory = 4;
    private final SimpleDateFormat iso8601 = new SimpleDateFormat("hh:mm");
    private static final Logger logger = LogManager.getLogger(DataMocker.class);

    public static void main(String[] args) {
        DataMocker mocker = new DataMocker();
        logger.info("UserId,DeviceId,Power,Date,StartTime,EndTime,Duration,KWh,DeviceType");
        for (int i = 1000; i < 1100; i++) {
            User user = new User(String.valueOf(i));

            mocker.setUserType(user);

            mocker.giveUserDevices(user);
            mocker.generateUsageLog(user);
        }


    }

    private void setUserType(User user) {
        UserType[] userTypeSample = new UserType[]{UserType.TYPEA, UserType.TYPEB, UserType.TYPEC, UserType.TYPED};
        Random random = new Random();
        user.setUserType(userTypeSample[random.nextInt(3)]);

    }


    private void giveUserDevices(User user) {
        Random random = new Random();
        // add ac
        AirConditioner airConditioner = new AirConditioner();
        int deviceCount = random.nextInt(4) + 1;

        for (int i = 0; i < deviceCount; i++) {

            user.addRtDevice(airConditioner.getRandomAC());
        }


        //add Electric Bicycle
        ElectricBicycle electricBicycle = new ElectricBicycle();
        user.addDevice(electricBicycle.getRandomELCBicycle());

        //add other electric devices, water heater, home theater
        Electrics electrics = new Electrics();
        deviceCount = 3;
        for (int i = 0; i < deviceCount; i++) {

            user.addDevice(electrics.getRandomELT());
        }

        //add Electric Cars for every 13 people
        if (Integer.parseInt(user.getId()) % 13 == 0) {
            ElectricCar electricCar = new ElectricCar();
            user.addDevice(electricCar.getRandomELCars());
        }

    }

    private void generateUsageLog(User user) {
        final Date today = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(today);

        // log template: userId,power,date,start time, end time, KWh
        String log = "%s, %s, %s, %s, %s, %s, %s, %s, %s";
        ;
        String date = DateFormat.getDateInstance(DateFormat.SHORT).format(today);
        // get ac
        for (Device device : user.rtDevices) {
            String startTime, endTime;
            int[] timeSample = AirConditioner.getSampleByUserType(user.getUserType());
            String powerConsumption;
            for (int aTimeSample : timeSample) {
                powerConsumption = getSampleConsumption(device);
                startTime = getStartHourText(aTimeSample);
                endTime = getEndHourText(aTimeSample,30);
                String consumptionByHour = new BigDecimal(powerConsumption).divide(new BigDecimal("1000"),BigDecimal.ROUND_CEILING).setScale(2, BigDecimal.ROUND_CEILING).toString();
                String logEntry = String.format(log, user.getId(),device.getId(), device.getPower(), date, startTime, endTime,
                        30, consumptionByHour, device.getType());
                logger.info(logEntry);

                startTime = endTime;
                endTime = getEndHourText(aTimeSample,60);
                 consumptionByHour = new BigDecimal(powerConsumption).divide(new BigDecimal("1000"),BigDecimal.ROUND_CEILING).setScale(2, BigDecimal.ROUND_CEILING).toString();
                 logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime,
                         30, consumptionByHour, device.getType());
                logger.info(logEntry);

            }
        }
        // Electric Bicycle
        for (Device device : user.devices) {
            int[] timeSample = AirConditioner.getSampleByUserType(UserType.TYPEB);
            Random random = new Random();
            int startHour = timeSample[random.nextInt(timeSample.length)];
            String duration;
            String consumption="";
            if (device.getCapacity() == null) {
                BigDecimal power = new BigDecimal(device.getPower());

                BigDecimal hours = new BigDecimal(String.valueOf(random.nextInt(4) + Math.random()));
                duration = hours.multiply(new BigDecimal("60")).setScale(0, BigDecimal.ROUND_CEILING).toString();
                consumption = power.divide(new BigDecimal("1000"),3).multiply(hours).setScale(2, BigDecimal.ROUND_CEILING).toString();
            } else {

                BigDecimal capacity = new BigDecimal(device.getCapacity());
                BigDecimal power = new BigDecimal(device.getPower());
                duration = capacity.divide(power,3, BigDecimal.ROUND_CEILING).multiply(new BigDecimal("60")).setScale(0, BigDecimal.ROUND_CEILING).toString();
                consumption = capacity.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_CEILING).setScale(2,BigDecimal.ROUND_CEILING).toString();
            }
            calendar.setTime(today);
            calendar.set(Calendar.HOUR_OF_DAY, startHour);
            calendar.set(Calendar.MINUTE, random.nextInt(59));
            String startTime = iso8601.format(calendar.getTime());
            calendar.add(Calendar.MINUTE, Integer.parseInt(duration));
            String endTime = iso8601.format(calendar.getTime());

            String logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime, duration, consumption, device.getType());
            logger.info(logEntry);

        }
    }

    private String getSampleConsumption(Device device) {
        BigDecimal power = new BigDecimal(device.getPower());
//      // now we sample every 30 seconds
        return power.multiply(new BigDecimal(String.valueOf(Math.random())))
                .divide(new BigDecimal("2"), 2, BigDecimal.ROUND_CEILING).toString();
    }

    private String getStartHourText(int hour) {
        Date today = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        return iso8601.format(calendar.getTime());
    }

    private String getEndHourText(int hour,int minute) {
        Date today = new Date();
        SimpleDateFormat iso8601 = new SimpleDateFormat("hh:mm");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.add(Calendar.MINUTE, minute);
        return iso8601.format(calendar.getTime());
    }

}
