package ru.job4j.phonebook;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import org.junit.Before;

import java.util.*;

/**
 * Test.
 */
public class SortUserTest {
    @Before
    public void incomingData() {

    }

    /**
     * Testing sequence of age.
     */
    @Test
    public void whenListByAgeNotSortedThenSetIsSortedByAge() {
        User1 us1 = new User1("Vital", 28);
        User1 us2 = new User1("Ivan", 18);
        User1 us3 = new User1("Antonio", 23);
        User1 us4 = new User1("Cj", 48);
        ArrayList<User1> users = new ArrayList<>(Arrays.asList(us1, us2, us3, us4));
        Set<User1> result = new SortUser().sort(users);
        List<User1> expected = new LinkedList<>();
        expected.add(us2);
        expected.add(us3);
        expected.add(us1);
        expected.add(us4);
        Set<User1> expected1 = new LinkedHashSet<>(expected);
        Assert.assertThat(result, Is.is(expected1));

    }

    /**
     * Testing sequence of name lengths.
     */
    @Test
    public void whenListByLNameNotSortedThenSetIsSortedByLName() {
        User1 us1 = new User1("Vital", 28);
        User1 us2 = new User1("Ivan", 18);
        User1 us3 = new User1("Antonio", 23);
        User1 us4 = new User1("Cj", 48);
        ArrayList<User1> users = new ArrayList<>(Arrays.asList(us1, us2, us3, us4));
        List<User1> result = new SortUser().sortNameLength(users);
        List<User1> expected = new LinkedList<>();
        expected.add(us4);
        expected.add(us2);
        expected.add(us1);
        expected.add(us3);
        Assert.assertThat(result, Is.is(expected));
    }

    /**
     * Testing sorting by name -> then by age.
     */
    @Test
    public void whenListByLNameAndAgeNotSortedThenListIsSortedByLNameAndAge() {
        User1 us1 = new User1("Sergey", 25);
        User1 us2 = new User1("Ivan", 30);
        User1 us3 = new User1("Sergey", 20);
        User1 us4 = new User1("Ivan", 25);
        ArrayList<User1> users = new ArrayList<>(Arrays.asList(us1, us2, us3, us4));
        List<User1> result = new SortUser().sortByAllFields(users);
        List<User1> expected = new LinkedList<>();
        expected.add(us4);
        expected.add(us2);
        expected.add(us3);
        expected.add(us1);
        Assert.assertThat(result, Is.is(expected));
    }
}
