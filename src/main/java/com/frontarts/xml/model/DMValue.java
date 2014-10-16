package com.frontarts.xml.model;

/**
 * Created by IntelliJ IDEA. @7/31/12 3:02 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class DMValue {

    private String value;

    private String href;

    public DMValue() {
    }

    public DMValue(String value, String href) {
        this.value = value;
        this.href = href;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
