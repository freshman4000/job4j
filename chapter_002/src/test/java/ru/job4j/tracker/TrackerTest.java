package ru.job4j.tracker;


import org.junit.Test;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
/**
 * Test.
 */
public class TrackerTest {
    /**
     * Testing addition.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assert.assertThat(result.getName(), Is.is(item.getName()));
    }
    /**
     * Testing replacement.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        Assert.assertThat(tracker.findById(previous.getId()).getName(), Is.is("test2"));
    }
    /**
     * Testing deletion.
     */
    @Test
    public void whenDeleteNameThenReturnItemNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        Item third = new Item("test3","testDescription3",12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String firstId = first.getId();
        String secondId = second.getId();
        String thirdId = third.getId();
        Assert.assertThat(tracker.findById(second.getId()).getId(), Is.is(secondId));
        tracker.delete(secondId);
        Assert.assertThat(tracker.findById(secondId), IsEqual.equalTo(null));
        Assert.assertThat(tracker.findById(first.getId()).getId(), Is.is(firstId));
        Assert.assertThat(tracker.findById(third.getId()).getId(), Is.is(thirdId));
    }
    /**
     * Testing search by name.
     */
    @Test
    public void whenFindAllThenReturnArrayNoNulls() {
        Tracker tracker = new Tracker();
        Item first = new Item("sameName","testDescription",123L);
        Item second = new Item("noTsameName","testDescription2",1234L);
        Item third = new Item("sameName","testDescription3",12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        int expected = 3;
        Assert.assertThat(tracker.findAll().length, Is.is(expected));
        Assert.assertThat(tracker.findAll()[0], IsEqual.equalTo(first));
        Assert.assertThat(tracker.findAll()[1], IsEqual.equalTo(second));
        Assert.assertThat(tracker.findAll()[2], IsEqual.equalTo(third));
        }
    /**
     * Testing search by name.
     */
    @Test
    public void whenFindByNameThenReturnArrayItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("sameName","testDescription",123L);
        Item second = new Item("noTsameName","testDescription2",1234L);
        Item third = new Item("sameName","testDescription3",12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String searchName = "sameName";
        Assert.assertThat(tracker.findByName(searchName)[0], IsEqual.equalTo(first));
        Assert.assertThat(tracker.findByName(searchName)[1], IsEqual.equalTo(third));
    }
    /**
     * Testing search by id.
     */
    @Test
    public void whenFindByIdThenReturnItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        Item third = new Item("test3","testDescription3",12345L);
        Item forth = new Item("notInStackName","notInStackDescription",10L);
        forth.setId("xxx");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String firstId = first.getId();
        String secondId = second.getId();
        String thirdId = third.getId();
        String thirdName = third.getName();
        String firstDesc = first.getDesc();
        Assert.assertThat(tracker.findById(secondId), IsEqual.equalTo(second));
        Assert.assertThat(tracker.findById(thirdId).getName(), Is.is(thirdName));
        Assert.assertThat(tracker.findById(firstId).getDesc(), Is.is(firstDesc));
        Assert.assertThat(tracker.findById("xxx"), IsEqual.equalTo(null));
    }
}
