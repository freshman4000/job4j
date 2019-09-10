package ru.job4j.xmlxstlmagnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private long result = 0;

    public long getResult() {
        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("entry")) {
            result += Integer.parseInt(attributes.getValue(0));
        }
    }
}
