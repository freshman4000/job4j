package ru.job4j;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public interface Controller {
    Set<String> getCurrentDBVacancies();

    Connection getConnection();

    Timestamp getLastDateParsed();

    Properties getProperties();

    void dbAndTableValidate();

    Connection initConnectionInstance();

    Connection initConnectionInstance(String database);

    Properties propLoader(String propFile);

    ArrayList<String> getDatabases();

    ArrayList<String> getTableNames();

    Set<String> getCurrentVacanciesFromDatabase();

    void close() throws Exception;

}
