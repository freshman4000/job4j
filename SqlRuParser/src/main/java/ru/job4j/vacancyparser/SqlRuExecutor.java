package ru.job4j.vacancyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.Controller;
import ru.job4j.Executor;
import ru.job4j.ParsableInfo;
import ru.job4j.Parser;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class SqlRuExecutor implements Executor {
    private static final Logger LOG = LogManager.getLogger(SqlRuExecutor.class.getName());
    public SqlRuController controller;
    public SqlRuParser parser;
    public String propURI;

    public SqlRuExecutor(Controller controller, Parser parser, String propURI) {
        this.controller = (SqlRuController) controller;
        this.parser = (SqlRuParser) parser;
        this.propURI = propURI;
    }

    @Override
    public void formFreshVacancies(Set<String> existing, Map<String, ParsableInfo> fresh) {
        for (Map.Entry<String, ParsableInfo> pair : fresh.entrySet()) {
            if (!existing.contains(pair.getKey())) {
                try (PreparedStatement pst = controller.getConnection().prepareStatement("INSERT INTO "
                        + controller.getProperties().getProperty("table")
                        + "(date, name, text, reference) VALUES (?, ?, ?, ?)")) {
                    pst.setTimestamp(1, (Timestamp) pair.getValue().getFields().get(0).getDescription());
                    pst.setString(2, (String) pair.getValue().getFields().get(1).getDescription());
                    pst.setString(3, (String) pair.getValue().getFields().get(3).getDescription());
                    pst.setString(4, (String) pair.getValue().getFields().get(2).getDescription());
                    pst.execute();
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public void execute() {
        try (SqlRuController controller = this.controller) {
            SqlRuParser parser = this.parser;
            Timestamp contrDate = controller.getLastDateParsed();
            parser.setOldestParsingDate(contrDate.after(parser.getOldestParsingDate()) ? controller.getLastDateParsed() : parser.getOldestParsingDate());
            Map<String, ParsableInfo> res = parser.getFreshVacancies();
            this.formFreshVacancies(controller.getCurrentDBVacancies(), res);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
