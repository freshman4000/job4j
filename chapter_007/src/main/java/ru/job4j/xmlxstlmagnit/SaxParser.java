package ru.job4j.xmlxstlmagnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {
    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());

    public void parseDoc(File file) {
        SaxHandler saxHandler = new SaxHandler();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(file, saxHandler);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        System.out.println(saxHandler.getResult());
    }

}

