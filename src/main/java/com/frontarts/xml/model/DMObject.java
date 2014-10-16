package com.frontarts.xml.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. @7/31/12 2:55 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class DMObject {
    // TODO, expose as Fields or Properties ?
    public Map<String, DMValue> singleAttributes = new HashMap<String, DMValue>();
    public Map<String, List<DMValue>> repeatAttributes = new HashMap<String, List<DMValue>>();
    public List<Link> links = new ArrayList<Link>();

    public Map<String, List<DMValue>> getRepeatAttributes() {
        return repeatAttributes;
    }

    public void setRepeatAttributes(Map<String, List<DMValue>> repeatAttributes) {
        this.repeatAttributes = repeatAttributes;
    }

    public Map<String, DMValue> getSingleAttributes() {

        return singleAttributes;
    }

    public void setSingleAttributes(Map<String, DMValue> singleAttributes) {
        this.singleAttributes = singleAttributes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        single attribute
        for (String s : singleAttributes.keySet()) {
            sb.append(s).append(":[").append(singleAttributes.get(s).getValue()).append("|").append(singleAttributes.get(s).getHref()).append("]\n");
        }

        // repeating attribute
        for (String s : repeatAttributes.keySet()) {
            sb.append(s).append(":[");
            for (DMValue var : repeatAttributes.get(s)) {
                sb.append("(").append(var.getValue()).append("|").append(var.getHref()).append("),");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
