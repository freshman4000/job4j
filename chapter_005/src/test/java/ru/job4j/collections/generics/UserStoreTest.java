package ru.job4j.collections.generics;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.NoSuchElementException;

/**
 * Test.
 */
public class UserStoreTest {
    UserStore us = new UserStore(5);

    /**
     * Testing addition.
     */
    @Test
    public void whenAddThenGet() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        us.add(u1);
        us.add(u2);
        us.add(u3);
        Assert.assertThat(us.findById("Vit"), Is.is(u2));
    }

    /**
     * Testing deletion.
     */
    @Test
    public void whenDeleteThenGetTrue() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        us.add(u1);
        us.add(u2);
        us.add(u3);
        Assert.assertThat(us.findById("Vit"), Is.is(u2));
        Assert.assertThat(us.delete("Vit"), Is.is(true));

    }

    /**
     * Testing replacement.
     */
    @Test
    public void whenReplaceThenGetTrue() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        us.add(u1);
        us.add(u2);
        us.add(u3);
        User u4 = new User("Jin");
        Assert.assertThat(us.replace("Vit", u4), Is.is(true));
    }

    /**
     * Testing NSE exception while FindingById.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNoIdWhenFindThenException() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        us.add(u1);
        us.add(u2);
        us.add(u3);
        us.findById("XXX");
    }

    /**
     * Testing boolean while deleting.
     */
    @Test
    public void whenNoIdWhenDeleteThenFalse() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        us.add(u1);
        us.add(u2);
        us.add(u3);
        Assert.assertThat(us.delete("XXX"), Is.is(false));
    }

    /**
     * Testing boolean value while replacing.
     */
    @Test
    public void whenNoIdWhenReplaceThenFalse() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        us.add(u1);
        us.add(u2);
        us.add(u3);
       Assert.assertThat(us.replace("XXX", new User("LoL")), Is.is(false));
    }

    /**
     * Testing UO exception while adding over limit.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void whenNoIdWhenOverAddThenUOException() {
        User u1 = new User("Sat");
        User u2 = new User("Vit");
        User u3 = new User("Art");
        User u4 = new User("Voj");
        User u5 = new User("Job");
        User u6 = new User("LoL");
        us.add(u1);
        us.add(u2);
        us.add(u3);
        us.add(u4);
        us.add(u5);
        us.add(u6);
    }
}
