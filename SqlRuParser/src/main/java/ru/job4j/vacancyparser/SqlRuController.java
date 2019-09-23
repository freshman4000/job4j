package ru.job4j.vacancyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.Controller;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class SqlRuController implements Controller, AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(SqlRuController.class.getName());
    private Connection connection;
    private Properties properties;
    private Set<String> currentDBVacancies;
    private Timestamp lastDateParsed;

    public SqlRuController(String propFile) {
        this.lastDateParsed = new Timestamp(1000000);
        this.properties = propLoader(propFile);
        this.connection = initConnectionInstance();
        dbAndTableValidate();
        this.currentDBVacancies = getCurrentVacanciesFromDatabase();
    }

    public Set<String> getCurrentDBVacancies() {
        return currentDBVacancies;
    }

    public Connection getConnection() {
        return connection;
    }

    public Timestamp getLastDateParsed() {
        return lastDateParsed;
    }

    public Properties getProperties() {
        return properties;
    }

    public void dbAndTableValidate() {
        try (Statement statement = connection.createStatement()) {
            if (!getDatabases().contains(properties.getProperty("database"))) {
                statement.executeUpdate("CREATE DATABASE " + properties.getProperty("database"));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                this.connection.close();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        initConnectionInstance(properties.getProperty("database"));
        try (Statement statement = connection.createStatement()) {
            if (!getTableNames().contains(properties.getProperty("table"))) {
                statement.executeUpdate("CREATE TABLE " + properties.getProperty("table")
                        + " (id SERIAL PRIMARY KEY NOT NULL, date TIMESTAMP NOT NULL, name VARCHAR(2000) NOT NULL, text TEXT NOT NULL, reference VARCHAR(2000) NOT NULL)");
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Method that initializes connection instance with no database connected.
     *
     * @return connection instance.
     */
    public Connection initConnectionInstance() {
        try {
            Class.forName(properties.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection;
    }

    /**
     * Method that initializes connection to specified database.
     *
     * @param database to be connected.
     * @return connection to database.
     */
    public Connection initConnectionInstance(String database) {
        try {
            Class.forName(properties.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection((properties.getProperty("url") + "/" + database),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection;
    }

    /**
     * Method that loads all properties of the class.
     *
     * @return properties object.
     */
    public Properties propLoader(String propFile) {
        Properties properties = new Properties();
        try (InputStream inputStream = SqlRuController.class.getClassLoader().getResourceAsStream(propFile)) {
            properties.load(inputStream);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return properties;
    }

    /**
     * Method that get all databases from current connection.
     *
     * @return list of databases.
     */
    public ArrayList<String> getDatabases() {
        ArrayList<String> dbNames = new ArrayList<>();
        if (this.connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery("SELECT datname FROM pg_database")) {
                while (rs.next()) {
                    dbNames.add(rs.getString(1));
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return dbNames;
    }

    /**
     * Method that get all names of tables from current database.
     *
     * @return list of table names.
     */
    public ArrayList<String> getTableNames() {
        ArrayList<String> tableNames = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(
                     "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' AND table_type = 'BASE TABLE'")) {
            while (rs.next()) {
                tableNames.add(rs.getString(1));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return tableNames;
    }

    /**
     * Gets the set of actual vacancy names from current version of database and sets last actual parseDate.
     *
     * @return set of current names.
     */
    public Set<String> getCurrentVacanciesFromDatabase() {
        Set<String> result = new HashSet<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name FROM " + properties.getProperty("table"));
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
            resultSet = statement.executeQuery("SELECT MAX(date) FROM " + properties.getProperty("table"));
            resultSet.next();
            if (resultSet.getTimestamp(1) != null) {
                lastDateParsed = resultSet.getTimestamp(1);
            }
            resultSet.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}
