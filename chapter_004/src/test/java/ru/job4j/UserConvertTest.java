package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;

/**
 * Test.
 */
public class UserConvertTest {
    /**
     * Testing.
     */
    @Test
    public void when3namesThen3Users() {
        List<String> names = Arrays.asList("Ben", "Cj", "Aj");
        List<UserConvert.User> result = new UserConvert().convert(names, UserConvert.User::new);
        Assert.assertThat(result, Is.is(Arrays.asList(new UserConvert.User("Ben"),
                new UserConvert.User("Cj"),
                new UserConvert.User("Aj"))));
    }
}
