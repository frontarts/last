package com.frontarts.xml.model;

/**
 * Created by IntelliJ IDEA. @8/6/12 5:39 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Link {

    private String rel;
    private String hrel;
    private String type;

    public Link(String rel, String hrel, String type) {
        this.rel = rel;
        this.hrel = hrel;
        this.type = type;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHrel() {
        return hrel;
    }

    public void setHrel(String hrel) {
        this.hrel = hrel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
