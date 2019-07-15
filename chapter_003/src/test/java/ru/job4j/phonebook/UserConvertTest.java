package ru.job4j.phonebook;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        List<User> lst = new ArrayList<>(Arrays.asList(us1, us2));
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, us1);
        expected.put(234, us2);
        HashMap<Integer, User> result = new UserConvert().process(lst);
        Assert.assertThat(result, Is.is(expected));
    }
}
