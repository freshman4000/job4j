import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.vacancyparser.Controller;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlRuParserTest {
    private static final Logger LOG = LogManager.getLogger(SqlRuParserTest.class.getName());

    public Connection init() {
        try (InputStream in = Controller.class.getClassLoader().getResourceAsStream("parser.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Properties test.
     */
    @Test
    public void createProperties() {
        Properties expected = new Properties();
        try (InputStream in = Controller.class.getClassLoader().getResourceAsStream("parser.properties")) {
            expected = new Properties();
            expected.load(in);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        Properties result = null;
        try (Controller ctr = new Controller("parser.properties")) {
            result = ctr.getProperties();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        Assert.assertThat(expected, Is.is(result));
    }
}
