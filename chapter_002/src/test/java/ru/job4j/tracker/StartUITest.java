package ru.job4j.tracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu =
            "0. Add new Item" + System.lineSeparator()
                    + "1. Show all items" + System.lineSeparator()
                    + "2. Edit item" + System.lineSeparator()
                    + "3. Delete item" + System.lineSeparator()
                    + "4. Find item by Id" + System.lineSeparator()
                    + "5. Find items by name" + System.lineSeparator()
                    + "6. Exit Program" + System.lineSeparator();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }
    @After
    public void loadDefaultOutput() {
        System.setOut(stdout);
    }
    /**
     * Show items testing when stack is not empty.
     */
    @Test
    public void whenShowAllThenShowItems() {
        String[] answers = new String[]{"1", "n", "6", "y"};
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(tracker, new StubInput(answers));
        Item item = tracker.add(new Item("n1", "d1"));
        startUI.init();
        String itemShowUp = item.toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(menu
                        + "------------ Showing all items --------------" + System.lineSeparator()
                        + itemShowUp + System.lineSeparator()
                        + menu
                        + "------------ Exiting program. Are you sure? --------------" + System.lineSeparator()));
    }
    /**
     * Show items testing when stack is empty.
     */
    @Test
    public void whenShowAllInEmptyThenShowMessage() {
        String[] answers = new String[]{"1", "n", "6", "y"};
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(tracker, new StubInput(answers));
        startUI.init();
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                menu
                        + "------------ Showing all items --------------" + System.lineSeparator()
                        + "--- List is empty. Try to add item. ---" + System.lineSeparator()
                        + menu
                        + "------------ Exiting program. Are you sure? --------------" + System.lineSeparator()));
    }
    /**
     * FindById() testing when id in list.
     */
    @Test
    public void whenFindIdThenShowItemsWithId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("n1", "d1"));
        String id = item.getId();
        String[] answers = new String[]{"4", id, "n", "6", "y"};
        StartUI startUI = new StartUI(tracker, new StubInput(answers));
        startUI.init();
        String itemShowUp = item.toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                menu
                        + "------------ Items search --------------" + System.lineSeparator()
                        + itemShowUp + System.lineSeparator()
                        + menu
                        + "------------ Exiting program. Are you sure? --------------" + System.lineSeparator()));
    }
    /**
     * FindById() testing when id NOT in list.
     */
    @Test
    public void whenFindIdThenShowMess() {
        Tracker tracker = new Tracker();
        String[] answers = new String[]{"4", "xxx", "n", "6", "y"};
        StartUI startUI = new StartUI(tracker, new StubInput(answers));
        startUI.init();
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                menu
                        + "------------ Items search --------------" + System.lineSeparator()
                        + "--- Item Id : " + "xxx" + " not found. Specify different id ---" + System.lineSeparator()
                        + menu
                        + "------------ Exiting program. Are you sure? --------------" + System.lineSeparator()));
    }
    /**
     * Testing search by name with names present.
     */
    @Test
    public void whenFindNameThenShowItemsWithName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("n1", "d1"));
        Item item2 = tracker.add(new Item("n1", "d2"));
        String name = item.getName();
        String[] answers = new String[]{"5", name, "n", "6", "y"};
        StartUI startUI = new StartUI(tracker, new StubInput(answers));
        startUI.init();
        String itemShowUp = item.toString();
        String item2ShowUp = item2.toString();
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                menu
                        + "------------ Show all items with given name --------------" + System.lineSeparator()
                        + itemShowUp + System.lineSeparator()
                        + item2ShowUp + System.lineSeparator()
                        + menu
                        + "------------ Exiting program. Are you sure? --------------" + System.lineSeparator()));
    }
    /**
     * Testing search by name with NO names present.
     */
    @Test
    public void whenFindNoNameThenShowMess() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("n1", "d1"));
        Item item2 = tracker.add(new Item("n1", "d2"));
        String[] answers = new String[]{"5", "xxx", "n", "6", "y"};
        StartUI startUI = new StartUI(tracker, new StubInput(answers));
        startUI.init();
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                menu
                        + "------------ Show all items with given name --------------" + System.lineSeparator()
                        + "--- List is empty. Try to add new item ---" + System.lineSeparator()
                        + menu
                        + "------------ Exiting program. Are you sure? --------------" + System.lineSeparator()));
    }
    /**
     * createItem() testing.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        String[] answers = new String[]{"0", "name1", "desc1", "n", "0", "name2", "desc2", "n", "6", "y"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(tracker, input);
        startUI.init();
        ArrayList<Item> result = tracker.findAll();
        Assert.assertThat(result.size(), Is.is(2));
        Assert.assertThat(result.get(0).getName(), Is.is("name1"));
        Assert.assertThat(result.get(0).getDesc(), Is.is("desc1"));
        Assert.assertThat(result.get(1).getName(), Is.is("name2"));
        Assert.assertThat(result.get(1).getDesc(), Is.is("desc2"));
    }
    /**
     * deleteItem() testing.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNextItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        String[] answers = new String[]{"0", "name2", "desc2", "n", "3", item.getId(), "n", "6", "y"};
        Input input = new StubInput(answers);
        StartUI startUI = new StartUI(tracker, input);
        startUI.init();
        ArrayList<Item> result = tracker.findAll();
        Assert.assertThat(result.size(), Is.is(1));
        Assert.assertThat(result.get(0).getName(), Is.is("name2"));
        Assert.assertThat(result.get(0).getDesc(), Is.is("desc2"));
    }
    /**
     * editItem() testing.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "n", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(tracker, input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Assert.assertThat(tracker.findById(item.getId()).getName(), Is.is("test replace"));
    }

}
