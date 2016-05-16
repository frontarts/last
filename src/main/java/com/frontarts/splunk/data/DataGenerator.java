package com.frontarts.splunk.data;

import com.frontarts.splunk.DataMocker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by IntelliJ IDEA. @5/12/16 2:41 PM
 * Author: wangy23
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class DataGenerator {

    private static final Logger logger = LogManager.getLogger(DataGenerator.class);

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        generator.generate();
    }

    private void generate() {
        String log = "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
        String apps[] = {"Wechat", "AliPay", "Pocket", "Zaker", "Hupu Sports",
                "Google Map", "Instagram", "Facebook", "Twitter", "vsco"};
        Map<String, Integer> appConfig = new HashMap<String, Integer>();
        appConfig.put("Wechat", 9);
        appConfig.put("AliPay", 6);
        appConfig.put("Pocket", 3);
        appConfig.put("Zaker", 5);
        appConfig.put("Hupu Sports", 4);
        appConfig.put("Google Map", 6);
        appConfig.put("Instagram", 7);
        appConfig.put("Facebook", 2);
        appConfig.put("Twitter", 3);
        appConfig.put("vsco", 1);

        StringBuilder header = new StringBuilder();
        for (String appName : apps) {
            header.append(appName).append(",");
        }
        logger.info(header.substring(0, header.length() - 1));

        for (int i = 0; i < 10000; i++) {
            Random random = new Random();

            StringBuilder appList = new StringBuilder();
            appList.append(random.nextInt(10) < appConfig.get("Wechat") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("AliPay") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Pocket") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Zaker") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Hupu Sports") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Google Map") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Instagram") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Facebook") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("Twitter") ? 1 : 0).append(",")
                    .append(random.nextInt(10) < appConfig.get("vsco") ? 1 : 0);


            logger.info(appList.toString());
        }
    }
}
