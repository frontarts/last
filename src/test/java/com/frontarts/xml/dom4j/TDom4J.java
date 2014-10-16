package com.frontarts.xml.dom4j;

import com.frontarts.xml.model.DMObject;
import com.frontarts.xml.model.DMValue;
import com.frontarts.xml.model.Link;
import com.frontarts.xml.util.Const;
import com.google.common.base.Strings;
import org.dom4j.*;
import org.dom4j.io.STAXEventReader;
import org.testng.annotations.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA. @8/6/12 11:00 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TDom4J {
    @Test
    public void testGenerate() {

    }

    //    @Test
    public DMObject testReadStAX() throws FileNotFoundException, XMLStreamException {

        STAXEventReader reader = new STAXEventReader();
        Document document = reader.readDocument(new FileInputStream(new File("src\\main\\resources\\object.xml")));
        System.out.println(document.getRootElement());
        Element root = document.getRootElement();
        DMObject dmObject = new DMObject();

        // TODO: use xPath to evaluate whether there's a child VS. using the iterator.
        /* -----------------------------------------ATTRIBUTES-----------------------------------------*/
        QName dmAttributeName = new QName("attributes", new Namespace("cst", "http://custom"));
        Element dmAttributeElement = root.element(dmAttributeName);
        for (Iterator it = dmAttributeElement.elementIterator(); it.hasNext(); ) {
            Element element = (Element) it.next();
            // check if is a repeating attribute ?
            if (element.elementIterator().hasNext()) {
                List<DMValue> repeatAttribute = new ArrayList<DMValue>();
                for (Iterator itv = element.elementIterator(); itv.hasNext(); ) {
                    Element rptEle = (Element) itv.next();
                    DMValue var = new DMValue(Strings.nullToEmpty(rptEle.getText()), Strings.nullToEmpty(rptEle.attributeValue(Const.ATTR_HREF)));
                    repeatAttribute.add(var);

                }
                dmObject.getRepeatAttributes().put(element.getName(), repeatAttribute);
            } else {
                DMValue value = new DMValue(Strings.nullToEmpty(element.getText()), Strings.nullToEmpty(element.attributeValue(Const.ATTR_HREF)));
                dmObject.getSingleAttributes().put(element.getName(), value);
            }

        }

        /*-----------------------------------------------LINKS---------------------------------------------------*/
        for (Iterator it = root.elementIterator(Const.QNL_LINK); it.hasNext(); ) {
            Element element = (Element) it.next();
            Link link = new Link(element.attributeValue(Const.ATTR_REL),
                    element.attributeValue(Const.ATTR_HREF), element.attributeValue(Const.ATTR_TYPE));
            dmObject.links.add(link);
        }
        return dmObject;


    }

    @Test
    public void testWriteXML() throws XMLStreamException, FileNotFoundException {

        DocumentFactory factory = DocumentFactory.getInstance();
        Document document = factory.createDocument();
        Element root = factory.createElement(QName.get("am_report", Namespace.get("cst", "http://custom")));
        root.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.addNamespace(Const.NS_DM, "http://ns.emc.com/documentum");
        root.addAttribute(QName.get("schemaLocation", Namespace.get("xsi", "http://www.w3.org/2001/XMLSchema-instance")),
                "http://localhost:8080/emc-rest/schemas/am_report.xsd");
        Element attributes = root.addElement(QName.get("attributes", new Namespace("cst", "http://custom")));
        DMObject dmObject = testReadStAX();
        // 1, attributes
        for (String attrName : dmObject.getSingleAttributes().keySet()) {
            DMValue value = dmObject.getSingleAttributes().get(attrName);
            Element attribute = attributes.addElement(QName.get(attrName, Namespace.get(Const.NS_DM, "http://ns.emc.com/documentum")))
                    .addText(value.getValue());
            // do not generate hrefs if they are empty
            if (!value.getHref().equals(""))
                attribute.addAttribute(Const.ATTR_HREF, value.getHref());

        }

        //2, links
        for (Link link : dmObject.links) {
            root.addElement(Const.QNL_LINK)
                    .addAttribute(Const.ATTR_REL,link.getRel())
                    .addAttribute(Const.ATTR_HREF,link.getHrel())
                    .addAttribute(Const.ATTR_TYPE, link.getType());

        }


        document.add(root);

        System.out.println(document.asXML());


    }
}
