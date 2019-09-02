package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private Connection connection;
    private boolean hasStructure;

    /**
     * This method initializes connection to database.
     *
     * @return boolean value.
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            hasStructure = getTableNames().containsAll(Arrays.asList(config.getProperty("structure").split(":")));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    private void validateStructure() {
        if (!hasStructure) {
            try (BufferedReader br = new BufferedReader(
                    new FileReader(System.getProperty("user.dir") + "/chapter_007/src/main/resources/script.sql"))) {
                Statement st = connection.createStatement();
                while (br.ready()) {
                    st.executeUpdate(br.readLine());
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            hasStructure = true;
            System.out.println("Structure created!");
        } else {
            System.out.println("Structure exists!");
        }
    }

    /**
     * This method validates ID input: checks if it is positive integer.
     *
     * @param id specified id.
     * @return boolean value.
     */
    private boolean validateId(String id) {
        boolean result = false;
        int idI = -1;
        try {
            idI = Integer.parseInt(id);
            if (idI > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Seems to be a problem with id input - its not a number!");
        }
        return result;
    }

    /**
     * This method validates Item object input: checks if it's fields contain appropriate name and description,
     * which should contain in dependent tables as item_state and item_category.
     *
     * @param item specified Item object.
     * @return boolean value.
     */
    private int[] validateItem(Item item) {
        int[] result = new int[3];
        String category = null;
        String state = null;
        if (getSpecifiedFields("item_category", "description").contains(item.getName())
                && getSpecifiedFields("item_state", "description").contains(item.getDesc())) {
            try {
                PreparedStatement pst = connection.prepareStatement("SELECT id FROM item_category WHERE description = ?");
                pst.setString(1, item.getName());
                ResultSet rs = pst.executeQuery();
                rs.next();
                category = rs.getString("id");
                pst = connection.prepareStatement("SELECT id FROM item_state WHERE description = ?");
                pst.setString(1, item.getDesc());
                ResultSet rs1 = pst.executeQuery();
                rs1.next();
                state = rs1.getString("id");
                rs.close();
                rs1.close();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Specify user ID from the following list :");
            List<String> idsOfUsers = getSpecifiedFields("users", "id");
            idsOfUsers.forEach(x -> System.out.print(x + " "));
            String idOfUser = "not in list";
            while (!idsOfUsers.contains(idOfUser)) {
                idOfUser = sc.nextLine();
            }
            result[0] = Integer.parseInt(state);
            result[1] = Integer.parseInt(idOfUser);
            result[2] = Integer.parseInt(category);
        }
        return result;
    }

    /**
     * Method that get all names of columns from specified table.
     *
     * @param tableName name of table from which names of columns are getting quired.
     * @return list of table column names.
     */
    private LinkedList<String> getTableColumnNames(String tableName) {
        LinkedList<String> columnNames = new LinkedList<>();
        try {
            PreparedStatement pst = connection.prepareStatement("SELECT column_name FROM information_schema.columns WHERE table_name = ?");
            pst.setString(1, tableName);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                columnNames.add(rs.getString(1));
            }
            rs.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return columnNames;
    }

    /**
     * Method that get all names of tables from current database.
     *
     * @return list of table names.
     */
    private ArrayList<String> getTableNames() {
        ArrayList<String> tableNames = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' AND table_type = 'BASE TABLE'");
            while (rs.next()) {
                tableNames.add(rs.getString(1));
            }
            rs.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return tableNames;
    }

    /**
     * THIS IS UTILITY METHOD for FUTURE USE!!!
     * Checks if table exists. Creates list of all fields for update in specified table.
     *
     * @param tableName name of table where update is taking place.
     * @return list of all updated fields in order.
     */
    private LinkedList<String> getAllFields(String tableName) {
        LinkedList<String> result = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int count = -1;
        ArrayList<String> tables = getTableNames();
        if (!tables.contains(tableName)) {
            throw new IllegalArgumentException("There is no table with such name");
        }
        LinkedList<String> columns = getTableColumnNames(tableName);
        while (count != columns.size() - 1) {
            count++;
            System.out.println("If you want to change field ==" + columns.get(count) + "== input data, if - not - press ENTER");
            String answer = sc.nextLine();
            result.add(answer);
        }
        return result;
    }

    /**
     * Checks if table exists. Creates list of all all values in specified column in specified table.
     * Since column and table names can't be specified in PreparedStatement, we use Statement for this purpose.
     * We know that it's not safe dew to SQL injection, but this method is for private use only, so its safe.
     *
     * @param tableName name of table where search is taking place.
     * @return list of all values if specified column in order of appearance.
     */

    private LinkedList<String> getSpecifiedFields(String tableName, String column) {
        LinkedList<String> result = new LinkedList<>();
        ArrayList<String> tables = getTableNames();
        if (!tables.contains(tableName)) {
            throw new IllegalArgumentException("There is no table with such name");
        }
        LinkedList<String> columns = getTableColumnNames(tableName);
        if (!columns.contains(column)) {
            throw new IllegalArgumentException("There is no column with such name");
        }
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT " + column + " FROM " + tableName);
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
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

    @Override
    public Item add(Item item) {
        boolean validated = true;
        boolean added = false;
        int[] validation = validateItem(item);
        for (int i = 0; i < validation.length; i++) {
            if (validation[i] <= 0) {
                validated = false;
            }
        }
        if (validated) {
            try {
                PreparedStatement pst = connection.prepareStatement(
                        "INSERT INTO items (id_state, id_user, id_category, item_date) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");
                pst.setInt(1, validation[0]);
                pst.setInt(2, validation[1]);
                pst.setInt(3, validation[2]);
                pst.executeUpdate();
                Statement st = connection.createStatement();
                ResultSet r1 = st.executeQuery("SELECT MAX(id) FROM items");
                r1.next();
                int currentId = r1.getInt(1);
                item.setId(String.valueOf(currentId));
                r1.close();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            added = true;
        }

        return added ? item : null;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean validated = true;
        boolean replaced = false;
        int[] validation = validateItem(item);
        for (int i = 0; i < validation.length; i++) {
            if (validation[i] <= 0) {
                validated = false;
            }
        }
        if (validated && validateId(id)) {
            try (PreparedStatement pst = connection.prepareStatement(
                    "UPDATE items SET (id_state, id_user, id_category, item_date) = (?, ?, ?, CURRENT_TIMESTAMP) WHERE id = ?");
            ) {
                int idI = Integer.parseInt(id);

                pst.setInt(1, validation[0]);
                pst.setInt(2, validation[1]);
                pst.setInt(3, validation[2]);
                pst.setInt(4, idI);
                pst.executeUpdate();
                item.setId(String.valueOf(idI));
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            replaced = true;
        }

        return replaced;
    }


    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (validateId(id)) {
            try (PreparedStatement pst = connection.prepareStatement("DELETE FROM items WHERE id = ?")) {

                pst.setInt(1, Integer.parseInt(id));
                int res = pst.executeUpdate();
                if (res == 1) {
                    result = true;
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM items")) {

            while (rs.next()) {
                int stateDescription = rs.getInt("id_state");
                PreparedStatement idDesc = connection.prepareStatement("SELECT description FROM item_state WHERE id = ?");
                idDesc.setInt(1, stateDescription);
                ResultSet rsd = idDesc.executeQuery();
                rsd.next();
                String description = rsd.getString("description");
                int categoryDescription = rs.getInt("id_category");
                PreparedStatement idCat = connection.prepareStatement("SELECT description FROM item_category WHERE id = ?");
                idCat.setInt(1, categoryDescription);
                ResultSet rsc = idCat.executeQuery();
                rsc.next();
                String category = rsc.getString("description");
                Item item = new Item(category, description);
                item.setId(rs.getString("id"));
                item.setTime(rs.getTimestamp("item_date").getTime());
                result.add(item);
                idDesc.close();
                idCat.close();
                rsd.close();
                rsc.close();
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(
                "SELECT * FROM items as i WHERE i.id_category in (SELECT s.id FROM item_category as s WHERE description = ?)")) {

            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int stateDescription = rs.getInt("id_state");
                PreparedStatement idDesc = connection.prepareStatement("SELECT description FROM item_state WHERE id = ?");
                idDesc.setInt(1, stateDescription);
                ResultSet rsd = idDesc.executeQuery();
                rsd.next();
                String description = rsd.getString("description");
                Item item = new Item(key, description);
                item.setId(rs.getString("id"));
                item.setTime(rs.getTimestamp("item_date").getTime());
                result.add(item);
            }
            rs.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        if (validateId(id)) {
            try (PreparedStatement st = connection.prepareStatement(
                    "SELECT * FROM items WHERE id = ?")) {

                st.setInt(1, Integer.parseInt(id));
                ResultSet rs = st.executeQuery();
                rs.next();
                int stateDescription = rs.getInt("id_state");
                PreparedStatement idDesc = connection.prepareStatement("SELECT description FROM item_state WHERE id = ?");
                idDesc.setInt(1, stateDescription);
                ResultSet rsd = idDesc.executeQuery();
                rsd.next();
                String description = rsd.getString("description");
                int categoryDescription = rs.getInt("id_category");
                PreparedStatement idCat = connection.prepareStatement("SELECT description FROM item_category WHERE id = ?");
                idCat.setInt(1, categoryDescription);
                ResultSet rsc = idCat.executeQuery();
                rsc.next();
                String category = rsc.getString("description");
                Item item = new Item(category, description);
                item.setId(rs.getString("id"));
                item.setTime(rs.getTimestamp("item_date").getTime());
                result = item;
                rs.close();
                idDesc.close();
                rsd.close();
                idCat.close();
                rsc.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        } else {
            System.out.println("Id should have positive numeric value! Please make another query!");
        }
        return result;

    }

    public static void main(String[] args) {
        try (TrackerSQL te = new TrackerSQL()) {
            te.init();
            te.validateStructure();
            new StartUI(te, new ValidateInput(new ConsoleInput()), System.out::println).init();
            te.findAll();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
