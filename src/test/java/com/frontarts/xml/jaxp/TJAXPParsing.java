package com.frontarts.xml.jaxp;

import org.testng.annotations.Test;
// DOM
import org.w3c.dom.Document;
// SAX
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
// JAXP
import javax.xml.parsers.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA. @8/3/12 11:46 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TJAXPParsing {

    @Test
    public void testParsing() throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // Turn on validation, and turn off namespaces
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(""), new MyHandler());

    }


    class MyHandler extends DefaultHandler {
        // SAX callback implementations from ContentHandler, ErrorHandler, etc.
    }


    @Test
    public void testDOMParsing() throws IOException, SAXException, ParserConfigurationException {
        // Get DMObject Builder Factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Turn on validation, and turn off namespaces
        factory.setValidating(true);
        factory.setNamespaceAware(false);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("an XML file");

        // Print the document from the DOM tree and
        //   feed it an initial indentation of nothing

    }
}
