package com.frontarts.splunk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangy23 on 8/6/15.
 */
public class DataMocker {

    private static final int acCategory = 10;
    private static final int electricsCategory = 5;
    private static final int autoCategory = 4;
    private static final int chargeCategory = 4;
    private final SimpleDateFormat iso8601 = new SimpleDateFormat("HH:mm");
    private static final Logger logger = LogManager.getLogger(DataMocker.class);

    public static void main(String[] args) {
        DataMocker mocker = new DataMocker();
        logger.info("UserId,DeviceId,Power,Date,StartTime,EndTime,Duration,KWh,DeviceType");
        Date today = new Date();
        for (int i = 1000; i < 1100; i++) {
            User user = new User(String.valueOf(i));

            mocker.setUserType(user);

            mocker.giveUserDevices(user);

            for (int j = 0; j < 30; j++) {
                Calendar day = new GregorianCalendar();
                day.setTime(today);
                day.add(Calendar.DAY_OF_MONTH, -j);
                mocker.generateUsageLogByDay(user, day);

            }
        }


    }

    private void setUserType(User user) {
        UserType[] userTypeSample = new UserType[]{UserType.TYPEA, UserType.TYPEB, UserType.TYPEC, UserType.TYPED};
        Random random = new Random();
        user.setUserType(userTypeSample[random.nextInt(4)]);

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

    private void generateUsageLogByDay(User user, Calendar calendar) {

        // log template: userId,power,date,start time, end time, KWh
        String log = "%s, %s, %s, %s, %s, %s, %s, %s, %s";
        ;
        String date = new SimpleDateFormat("YYYY/MM/dd").format(calendar.getTime());
        // get ac
        for (Device device : user.rtDevices) {
            String startTime, endTime;
            int[] timeSample = AirConditioner.getSampleByUserType(user.getUserType());
            String powerConsumption;

            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            List<Integer> sample = new ArrayList<Integer>();
            Random index = new Random();
            if (dayOfMonth % 3 == 0) {
                int toBeRemove = index.nextInt(3);
                for (int i = 0; i < toBeRemove; i++) {

                    timeSample[index.nextInt(timeSample.length)] = 0;
                }

                for (int aTimeSample : timeSample) {
                    if (aTimeSample != 0) sample.add(aTimeSample);
                }
            }

            if (dayOfMonth % 2 == 0) {
                int toBeRemove = index.nextInt(2);
                for (int i = 0; i < toBeRemove; i++) {

                    timeSample[index.nextInt(timeSample.length)] = 0;
                }
                for (int aTimeSample : timeSample) {
                    if (aTimeSample != 0) sample.add(aTimeSample);
                }
            }

            for (Integer aTimeSample : sample) {
                powerConsumption = getSampleConsumption(device);
                startTime = getStartHourText(aTimeSample);
                endTime = getEndHourText(aTimeSample, 30);
                String consumptionByHour = new BigDecimal(powerConsumption).divide(new BigDecimal("1000"), BigDecimal.ROUND_CEILING).setScale(2, BigDecimal.ROUND_CEILING).toString();
                String logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime,
                        30, consumptionByHour, device.getType());
                logger.info(logEntry);

                startTime = endTime;
                endTime = getEndHourText(aTimeSample, 60);
                consumptionByHour = new BigDecimal(powerConsumption).divide(new BigDecimal("1000"), BigDecimal.ROUND_CEILING).setScale(2, BigDecimal.ROUND_CEILING).toString();
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
            calendar.set(Calendar.HOUR_OF_DAY, startHour);
            String duration;
            String consumption = "";
            String startTime, endTime;

            if (device.getType().startsWith("ELTC")) {

                BigDecimal power = new BigDecimal(device.getPower());

                // before
                int beforeMinutes = random.nextInt(28) + 1;
                if (random.nextBoolean()) {
                    calendar.set(Calendar.MINUTE, 0);
                    startTime = iso8601.format(calendar.getTime());
                    calendar.set(Calendar.MINUTE, 30);
                    endTime = iso8601.format(calendar.getTime());
                } else {
                    calendar.set(Calendar.MINUTE, 30);
                    startTime = iso8601.format(calendar.getTime());
                    calendar.add(Calendar.HOUR, 1);
                    calendar.set(Calendar.MINUTE, 0);
                    endTime = iso8601.format(calendar.getTime());
                }
                printSampleConsuption(user, log, date, device, startTime, endTime, power, beforeMinutes);

                // log middle sample
                for (int i = 0; i < random.nextInt(5); i++) {
                    startTime = iso8601.format(calendar.getTime());
                    calendar.add(Calendar.MINUTE, 30);
                    endTime = iso8601.format(calendar.getTime());
                    printSampleConsuption(user, log, date, device, startTime, endTime, power, 30);
                }

                // log after sample
                int after = random.nextInt(28) + 1;
                startTime = iso8601.format(calendar.getTime());
                calendar.add(Calendar.MINUTE, 30);
                endTime = iso8601.format(calendar.getTime());
                printSampleConsuption(user, log, date, device, startTime, endTime, power, after);

            } else {    // chargers

                BigDecimal capacity = new BigDecimal(device.getCapacity());
                BigDecimal power = new BigDecimal(device.getPower());
                // get duration in minute
                duration = capacity.divide(power, 3, BigDecimal.ROUND_CEILING).multiply(new BigDecimal("60")).setScale(0, BigDecimal.ROUND_CEILING).toString();
                int beforeMinutes = random.nextInt(28) + 1;
                int halves = Integer.parseInt(duration) / 30;
                int after = Integer.parseInt(duration) % 30 - beforeMinutes;
                if (beforeMinutes - Integer.parseInt(duration) % 30 > 0) {
                    halves--;
                    after += 30;
                }
                calendar.set(Calendar.HOUR_OF_DAY, startHour);

                if (random.nextBoolean()) {
                    calendar.set(Calendar.MINUTE, 0);
                    startTime = iso8601.format(calendar.getTime());
                    calendar.set(Calendar.MINUTE, 30);
                    endTime = iso8601.format(calendar.getTime());
                } else {
                    calendar.set(Calendar.MINUTE, 30);
                    startTime = iso8601.format(calendar.getTime());
                    calendar.add(Calendar.HOUR, 1);
                    endTime = iso8601.format(calendar.getTime());
                }

                BigDecimal powerKWH = power.divide(new BigDecimal("1000"), 3, BigDecimal.ROUND_CEILING);
                consumption = powerKWH.multiply(getDuration(beforeMinutes)).setScale(2, BigDecimal.ROUND_CEILING).toString();
                String logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime,
                        30, consumption, device.getType());
                logger.info(logEntry);

                // for middle half hours
                consumption = powerKWH.multiply(getDuration(30)).setScale(2, BigDecimal.ROUND_CEILING).toString();
                for (int i = 0; i < halves; i++) {
                    startTime = iso8601.format(calendar.getTime());
                    calendar.add(Calendar.MINUTE, 30);
                    endTime = iso8601.format(calendar.getTime());
                    logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime,
                            30, consumption, device.getType());
                    logger.info(logEntry);
                }

                // for after minutes
                if (after != 0) {
                    startTime = iso8601.format(calendar.getTime());

                    calendar.add(Calendar.MINUTE, 30);
                    endTime = iso8601.format(calendar.getTime());
                    consumption = powerKWH.multiply(getDuration(after)).setScale(2, BigDecimal.ROUND_CEILING).toString();

                    logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime,
                            30, consumption, device.getType());
                    logger.info(logEntry);
                }

            }

        }

    }

    private void printSampleConsuption(User user, String log, String date, Device device, String startTime, String endTime, BigDecimal power, int duration) {
        String consumption;
        BigDecimal powerKWH = power.divide(new BigDecimal("1000"), 3, BigDecimal.ROUND_CEILING);
        consumption = powerKWH.multiply(getDuration(duration)).setScale(2, BigDecimal.ROUND_CEILING).toString();
        String logEntry = String.format(log, user.getId(), device.getId(), device.getPower(), date, startTime, endTime,
                30, consumption, device.getType());
        logger.info(logEntry);
    }

    private BigDecimal getDuration(int beforeMinutes) {
        return new BigDecimal(beforeMinutes).divide(new BigDecimal(60), 3, BigDecimal.ROUND_CEILING);
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

    private String getEndHourText(int hour, int minute) {
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
