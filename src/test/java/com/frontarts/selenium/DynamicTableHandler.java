package com.frontarts.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by IntelliJ IDEA. @5/13/2015 4:57 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */

public class DynamicTableHandler {

    public static void main(String[] a) throws InterruptedException {
        // Initialize Web driver
        WebDriver driver = new FirefoxDriver();
        //Maximize browser window
        driver.manage().window().maximize();
        //Go to Page
        driver.get("file:///F:/table.html");
        //get the entire html table and store this in a variable
        // using the css selector to find the table
        WebElement table = driver.findElement(By.xpath("html/body/table/tbody"));
        //Get all the rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int r = 0; r < rows.size(); r++) {
            //Get all the columns in every row
            List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
            for (int col = 0; col < columns.size(); col++) {
                System.out.print(columns.get(col).getText().trim() + "   ");
            }
            System.out.println();
        }
        driver.quit();
    }

}
