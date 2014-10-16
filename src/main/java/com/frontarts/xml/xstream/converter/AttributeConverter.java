package com.frontarts.xml.xstream.converter;

import com.frontarts.xml.model.DMValue;
import com.frontarts.xml.xstream.util.Const;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Created by IntelliJ IDEA. @7/31/12 3:20 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class AttributeConverter implements Converter {
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {

        DMValue attribute = (DMValue) value;
//        writer.startNode(attribute.getName());
        writer.addAttribute(Const.ATTR_HREF, attribute.getHref());
        writer.setValue(attribute.getValue());
        writer.endNode();


    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {

        DMValue attribute = new DMValue();
        reader.moveDown();
//        attribute.setName(reader.getNodeName());
        attribute.setValue(reader.getValue());
//        attribute.setHref(reader.getAttribute(Const.ATTR_HREF));

        return attribute;

    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(DMValue.class);
    }
}
