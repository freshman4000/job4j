package ru.job4j.tracker;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

public class StartUITest {
    /**
     * createItem() testing.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        String[] answers = new String[]{"0", "name1", "desc1", "0", "name2", "desc2", "6"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(tracker, input);
        startUI.init();
        Item[] result = tracker.findAll();
        Assert.assertThat(result.length, Is.is(2));
        Assert.assertThat(result[0].getName(), Is.is("name1"));
        Assert.assertThat(result[0].getDesc(), Is.is("desc1"));
        Assert.assertThat(result[1].getName(), Is.is("name2"));
        Assert.assertThat(result[1].getDesc(), Is.is("desc2"));
    }
    /**
     * deleteItem() testing.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNextItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "desc1"));
        String[] answers = new String[]{"0", "name2", "desc2", "3", item.getId(), "6"};
        Input input = new StubInput(answers);
        StartUI startUI = new StartUI(tracker, input);
        startUI.init();
        Item[] result = tracker.findAll();
        Assert.assertThat(result.length, Is.is(1));
        Assert.assertThat(result[0].getName(), Is.is("name2"));
        Assert.assertThat(result[0].getDesc(), Is.is("desc2"));
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
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(tracker, input).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Assert.assertThat(tracker.findById(item.getId()).getName(), Is.is("test replace"));
    }

}
