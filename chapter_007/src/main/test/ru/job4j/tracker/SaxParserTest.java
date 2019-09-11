package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;
import ru.job4j.xmlxstlmagnit.*;

import java.io.File;

public class SaxParserTest {
    private static final Logger LOG = LogManager.getLogger(SaxParserTest.class.getName());
    @Test
    public void when1000kThenTimeLessThen600() {

            long startTime = System.currentTimeMillis();
            try (StoreSQL storeSQL = new StoreSQL(new Config())) {
                storeSQL.generate(10000);
                new StoreXML(new File("./db.xml")).save(storeSQL.load());
                new ConvertXSLT().convert(new File("db.xml"), new File("xslRes.xml"), new File("../scheme.xsl"));
                new SaxParser().parseDoc(new File("xslRes.xml"));
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            long time = (System.currentTimeMillis() - startTime)/1000;
            Assert.assertTrue(time<600);
    }
}
