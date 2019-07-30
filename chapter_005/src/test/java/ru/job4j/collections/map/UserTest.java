package ru.job4j.collections.map;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.text.ParseException;
import java.util.*;

/**
 * Test.
 */
public class UserTest {
    /**
     * Testing map with not overriden hashcode and equals().
     */
    @Test
    public void whenTwoObjHashAndEqualsNotOverridenThenTwoObj() throws ParseException {

        User us1 = new User("John", 0, new GregorianCalendar(2001, Calendar.APRIL,11));
        User us2 = new User("John", 0, new GregorianCalendar(2001, Calendar.APRIL,11));

        Map<User, Object> map = new HashMap<>();
        map.put(us1, "first");
        map.put(us2, "second");
        System.out.println(map);
    }
}
