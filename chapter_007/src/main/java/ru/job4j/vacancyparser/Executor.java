package ru.job4j.vacancyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Executor {
    private static final Logger LOG = LogManager.getLogger(HTMLParser.class.getName());
    public Controller controller;
    public HTMLParser htmlParser;
    public String propURI;

    public Executor(Controller controller, HTMLParser htmlParser, String propURI) {
        this.controller = controller;
        this.htmlParser = htmlParser;
        this.propURI = propURI;
    }

    public void formFreshVacancies(Set<String> existing, Map<String, Vacancy> fresh) {
        for (Map.Entry<String, Vacancy> pair : fresh.entrySet()) {
            if (!existing.contains(pair.getKey())) {
                try (PreparedStatement pst = controller.getConnection().prepareStatement("INSERT INTO "
                        + controller.getProperties().getProperty("table")
                        + "(date, name, text, reference) VALUES (?, ?, ?, ?)")) {
                    pst.setTimestamp(1, pair.getValue().date);
                    pst.setString(2, pair.getValue().name);
                    pst.setString(3, pair.getValue().text);
                    pst.setString(4, pair.getValue().reference);
                    pst.execute();
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    public void execute() {
        try (Controller controller = new Controller(this.propURI)) {
            HTMLParser parser = new HTMLParser("https://www.sql.ru/forum/job-offers", 1);
            Date contrDate = new Date(controller.getLastDateParsed().getDate());
            parser.setParseTime(contrDate.after(parser.getParseTime()) ? controller.getLastDateParsed() : parser.getParseTime());
            parser.getWholeContent();
            this.formFreshVacancies(controller.getCurrentDBVacancies(), parser.getParsedVacs());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
