package ru.job4j.xmlxstlmagnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class StoreSQL implements AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());
    private final Config config;
    private Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
        config.init();
        try {
            String[] buf = config.get("url").split(":");
            if (!Paths.get(System.getProperty("user.dir") + "/" + buf[buf.length - 1]).toFile().isFile()) {
                System.out.println("db " + buf[buf.length - 1] + " does not exist. Creating DB.");
                Files.createFile(Paths.get(System.getProperty("user.dir") + "/" + buf[buf.length - 1]));
            }
            connection = DriverManager.getConnection(config.get("url"));
        } catch (Exception s) {
            LOG.error(s.getMessage(), s);
        }
    }

    private boolean checkTableExistance() {
        boolean exists = false;
        try (Statement st = connection.createStatement()) {
            ResultSet rst = st.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
            while (rst.next()) {
                if (rst.getString(1).equals("entries")) {
                    exists = true;
                    break;
                }
            }
            rst.close();
        } catch (Exception s) {
            LOG.error(s.getMessage(), s);
        }
        return exists;
    }

    private void prepareTable() {
        if (checkTableExistance()) {
            try (Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM entries");
                if (rs.getInt(1) > 0) {
                    st.executeUpdate("DELETE FROM entries");
                }
                rs.close();
            } catch (Exception s) {
                LOG.error(s.getMessage(), s);
            }
        } else {
            try (Statement st = connection.createStatement()) {
                st.executeUpdate("CREATE TABLE entries (id INTEGER PRIMARY KEY NOT NULL, field INT NOT NULL)");
            } catch (Exception s) {
                LOG.error(s.getMessage(), s);
            }
        }
    }

    public void generate(int size) {
        prepareTable();
        try (PreparedStatement pst = connection.prepareStatement("INSERT INTO entries (field) VALUES ( ? )")) {
            connection.setAutoCommit(false);
            for (int i = 1; i <= size; i++) {
                pst.setInt(1, i);
                pst.executeUpdate();
            }
        } catch (Exception s) {
            LOG.error(s.getMessage(), s);
            try {
                connection.setAutoCommit(true);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }

        }
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public List<Entry> load() {
        List<Entry> result = new LinkedList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM entries");
            while (rs.next()) {
                result.add(new Entry(rs.getInt(1), rs.getInt(2)));
            }
            rs.close();
        } catch (Exception s) {
            LOG.error(s.getMessage(), s);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
