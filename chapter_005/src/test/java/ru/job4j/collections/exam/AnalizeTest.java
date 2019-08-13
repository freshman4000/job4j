package ru.job4j.collections.exam;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.collections.exam.Analize.User;

import java.util.Arrays;
import java.util.List;

/**
 * Test.
 */
public class AnalizeTest {
    User us1 = new User(1, "John");
    User us2 = new User(2, "Mary");
    User us3 = new User(3, "Bod");
    User us4 = new User(4, "Frank");

    /**
     * Testing addition.
     */
    @Test
    public void whenAdded2ThenAdded2() {
        Analize analize = new Analize();
        List<User> previous = Arrays.asList(us1, us2);
        List<User> current = Arrays.asList(us1, us2, us3, us4);
        Assert.assertThat(analize.diff(previous, current), Is.is(new Analize.Info(2, 0, 0)));
    }

    /**
     * Testing deletion.
     */
    @Test
    public void whenDeleted2ThenDeleted2() {
        Analize analize = new Analize();
        List<User> previous = Arrays.asList(us1, us2, us3, us4);
        List<User> current = Arrays.asList(us2, us3);
        Assert.assertThat(analize.diff(previous, current), Is.is(new Analize.Info(0, 0, 2)));
    }

    /**
     * Testing changes.
     */
    @Test
    public void whenChanged2ThenChanged2() {
        Analize analize = new Analize();
        List<User> previous = Arrays.asList(us2, us3);
        List<User> current = Arrays.asList(new User(2, "xxx"), new User(3, "yyy"));
        Assert.assertThat(analize.diff(previous, current), Is.is(new Analize.Info(0, 2, 0)));
    }
}
