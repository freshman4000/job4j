package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.integrationtests.ConnectionRollback;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    private static final Logger LOG = LogManager.getLogger(TrackerSQLTest.class.getName());

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
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
     * Item creation test.
     */
    @Test
    public void createItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("floor_slab_no_ground", "finished"));
            assertThat(tracker.findByName("floor_slab_no_ground").size(), is(4));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Deleting item.
     */
    @Test
    public void deleteItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.delete("2");
            assertThat(tracker.findByName("floor_slab_no_ground").size(), is(2));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Replacing item.
     */
    @Test
    public void replaceItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.replace("2", new Item("crossbar", "finished"));
            assertThat(tracker.findByName("crossbar").size(), is(2));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Finding all items.
     */
    @Test
    public void findAllItems() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.findAll().size(), is(7));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Finding items by name.
     */
    @Test
    public void findItemsByName() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.findByName("crossbar").get(0).getName(), is("crossbar"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Finding items by id.
     */
    @Test
    public void findItemsById() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.findById("6").getId(), is("6"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

