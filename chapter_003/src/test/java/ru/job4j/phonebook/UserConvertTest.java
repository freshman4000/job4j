package ru.job4j.phonebook;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.*;

/**
 * Test.
 */
public class UserConvertTest {
    /**
     * Testing conversion from list of users to HashMap.
     */
    @Test
    public void when3usersThen3KeySetsInMap() {
        User us1 = new User(1, "Vit", "Moscow");
        User us2 = new User(234, "Ivan", "Barnaul");
        List<User> lst = List.of(us1, us2);
        Map<Integer, User> expected = Map.of(1, us1, 234, us2);
        HashMap<Integer, User> result = new UserConvert().process(lst);
        Assert.assertThat(result, Is.is(expected));
    }
}
