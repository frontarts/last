package com.frontarts.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by IntelliJ IDEA. @5/13/2015 5:00 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TablePageObject {

    private WebDriver driver;

    @FindBy(css = "table tr")
    private List<WebElement> allTableRows; // find all the rows of the table

    public TablePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String SecurityName) {
        for (WebElement row : allTableRows) {
            List<WebElement> links = row.findElements(By.linkText("ABB"));
            // the first link by row is the company name, the second is link to be clicked
            if (links.get(0).getText().contains(SecurityName)) {
                links.get(0).click();
            }
        }

    }

}

