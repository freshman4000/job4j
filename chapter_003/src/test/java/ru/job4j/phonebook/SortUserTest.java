package ru.job4j.phonebook;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.*;

/**
 * Test.
 */
public class SortUserTest {
    /**
     * Testing sequence.
     */
    @Test
    public void whenListByAgeNotSortedThenSetIsSortedByAge() {
        User1 us1 = new User1("Vit", 28);
        User1 us2 = new User1("Iva", 18);
        User1 us3 = new User1("Ant", 23);
        User1 us4 = new User1("Tol", 48);
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
}
