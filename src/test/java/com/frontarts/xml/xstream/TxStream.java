package com.frontarts.xml.xstream;

import com.frontarts.xml.model.DMObject;
import com.frontarts.xml.model.DMValue;
import com.frontarts.xml.xstream.converter.AttributeConverter;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA. @7/31/12 1:38 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TxStream {
    @Test
    public void testMarshallVDNDocumentAtom(){

    }

    @Test
    public void testImplicitMapEntry(){
        DMObject document = new DMObject();

        List<DMValue> attributes = new ArrayList<DMValue>();
//        attributes.add(new DMValue("name","wangy23","http://www.emc.com"));
//        attributes.add(new DMValue("name","fellix","http://www.microsoft.com"));

//        document.setAttributes(attributes);

        XStream xStream = new XStream();
        xStream.addImplicitCollection(DMObject.class,"attributes");
//        xStream.registerConverter(new AttributeConverter());
//        xStream.registerConverter(new RestListConverter(xStream.getMapper()));

        System.out.println(xStream.toXML(document));

    }

    @Test
    public void testUnmarshal(){
        XStream xStream = new XStream();
        xStream.addImplicitCollection(DMObject.class,"attributes");
        xStream.registerConverter(new AttributeConverter());

     DMObject document = (DMObject) xStream.fromXML(new File("src\\test\\resources\\out.xml"));
//        System.out.printf(document.getAttributes().size()+"");
    }
}
