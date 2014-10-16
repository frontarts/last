package com.frontarts.xml;

import org.testng.annotations.Test;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by IntelliJ IDEA. @6/12/12 2:52 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TXsltTransformation {

    private String binFolder = "bin/";
    private String xmlFile = binFolder + "hello.xml";
    private String xsltFile = binFolder + "hello.xsl";

    @Test
    public void testHelloJAXPXalan() throws TransformerException, FileNotFoundException {


        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource(xsltFile));

        transformer.transform(new StreamSource(xmlFile), new StreamResult(new FileOutputStream("hello.out")));

    }

    @Test
    public void testHelloSAXON() {


    }
}
