package com.frontarts.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA. @5/13/2015 4:40 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TableTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.toolsqa.com/automation-practice-table";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iterateTable() {

        driver.get(baseUrl);
        WebElement WebTable = driver.findElement(By.cssSelector("*[summary='Sample Table']")); // Replace TableID with Actual Table ID or Xpath
        //        List<WebElement> TotalRowCount = Webtable.findElements(By.xpath("//*[@id='TableID']/tbody/tr"));
        List<WebElement> TotalRowCount = WebTable.findElements(By.cssSelector("tbody>tr"));

        System.out.println("No. of Rows in the WebTable: " + TotalRowCount.size());
        // Now we will Iterate the Table and print the Values
        int RowIndex = 1;
        for (WebElement rowElement : TotalRowCount) {
            List<WebElement> TotalColumnCount = rowElement.findElements(By.cssSelector("td"));
            int ColumnIndex = 1;
            for (WebElement colElement : TotalColumnCount) {
                System.out.println("Row " + RowIndex + " Column " + ColumnIndex + " Data " + colElement.getText());
                ColumnIndex = ColumnIndex + 1;
            }
            RowIndex = RowIndex + 1;
        }

    }

    @AfterTest
    public void tearDown() throws Exception {
        //        driver.quit();
    }

}
