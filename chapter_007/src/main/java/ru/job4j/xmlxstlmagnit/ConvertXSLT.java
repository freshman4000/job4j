package ru.job4j.xmlxstlmagnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class ConvertXSLT {
    private static final Logger LOG = LogManager.getLogger(ConvertXSLT.class.getName());

    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(
                    new StreamSource(
                            new FileInputStream(scheme))
            );
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        try {
            transformer.transform(new StreamSource(new FileInputStream(source)),
                    new StreamResult(new FileOutputStream(dest)));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

