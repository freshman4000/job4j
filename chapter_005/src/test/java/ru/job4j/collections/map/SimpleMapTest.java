package ru.job4j.collections.map;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test.
 */
public class SimpleMapTest {
    /**
     * Testing map methods behavior.
     */
    @Test
    public void whenInsertThenGet() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("one", "BMW");
        map.insert("two", "Mercedes");
        Assert.assertThat(map.get("one"), Is.is("BMW"));
        Assert.assertThat(map.get("two"), Is.is("Mercedes"));
        Assert.assertThat(map.get("XXX"), IsNull.nullValue());
        map.insert(null, "Audi");
        Assert.assertThat(map.get(null), Is.is("Audi"));
        Assert.assertThat(map.insert(null, "Acura"), Is.is(false));
        Assert.assertThat(map.delete(null), Is.is(true));
        Assert.assertThat(map.get(null), IsNull.nullValue());
        Assert.assertThat(map.insert("one", "Honda"), Is.is(false));
        Assert.assertThat(map.delete("one"), Is.is(true));
        Assert.assertThat(map.get("one"), IsNull.nullValue());
        map.insert("owt", "BMW"); //same bucket == 12
        Assert.assertThat(map.get("owt"), Is.is("BMW"));
        Assert.assertThat(map.get("two"), Is.is("Mercedes"));
    }

    /**
     * Testing map iterator behavior.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIterateThenGet() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("one", "BMW");
        map.insert("oen", "Kia");
        map.insert("eno", "Scoda");
        map.insert("two", "Mercedes");
        map.insert("wto", "Audi");
        map.insert("owt", "Honda");
        map.insert("otw", "Acura");
        map.insert(null, "Lada");
        Iterator it = map.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(((SimpleMap.Node) it.next()).getValue(), Is.is("Lada"));
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        Assert.assertThat(it.hasNext(), Is.is(false));
        it.next();
    }
}
