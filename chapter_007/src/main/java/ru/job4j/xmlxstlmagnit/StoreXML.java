package ru.job4j.xmlxstlmagnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;

public class StoreXML {
    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Entries {
        @XmlElement(name = "entry")
        private List<Entry> entries;

        public Entries() {
        }

        public Entries(List<Entry> entries) {
            this.entries = entries;
        }

        public List<Entry> getValues() {
            return entries;
        }

        public void setValues(List<Entry> entries) {
            this.entries = entries;
        }
    }

    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new Entries(list), target);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

