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
        List<User1> users = List.of(us1, us2, us3, us4);
        Set<User1> result = new SortUser().sort(users);
        List<User1> expected = List.of(us2, us3, us1, us4);
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
        List<User1> users = Arrays.asList(us1, us2, us3, us4);
        List<User1> result = new SortUser().sortNameLength(users);
        List<User1> expected = List.of(us4, us2, us1, us3);
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
        List<User1> users = Arrays.asList(us1, us2, us3, us4);
        List<User1> result = new SortUser().sortByAllFields(users);
        List<User1> expected = List.of(us4, us2, us3, us1);
        Assert.assertThat(result, Is.is(expected));
    }
}
