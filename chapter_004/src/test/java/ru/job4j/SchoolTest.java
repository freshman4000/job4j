package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;

/**
 * Test.
 */
public class SchoolTest {
    List<Student> list = Arrays.asList(new Student(99), new Student(23),
            new Student(76), new Student(48),
            new Student(87), new Student(88),
            new Student(35), new Student(18),
            new Student(66), new Student(100),
            new Student(12), new Student(32),
            new Student(0), new Student(72),
            new Student(56), new Student(41));

    /**
     * Testing aggregation by score below or equal to 50. Class C.
     */
    @Test
    public void when0To50InclusiveThanGetThoseToTheList() {
        List<Student> result = School.collect(list, x -> x.getScore() <= 50);
        Assert.assertThat(result, Is.is(Arrays.asList(list.get(1), list.get(3), list.get(6),
                list.get(7), list.get(10), list.get(11), list.get(12), list.get(15))));
    }

    /**
     * Testing aggregation by score between 50 and 70.
     */
    @Test
    public void when50To70ThanGetThoseToTheList() {
        List<Student> result = School.collect(list, x -> x.getScore() > 50 && x.getScore() <= 70);
        Assert.assertThat(result, Is.is(Arrays.asList(list.get(8), list.get(14))));
    }

    /**
     * Testing aggregation by score more than 70.
     */
    @Test
    public void when70To100ThanGetThoseToTheList() {
        List<Student> result = School.collect(list, x -> x.getScore() > 70);
        Assert.assertThat(result, Is.is(Arrays.asList(list.get(0), list.get(2), list.get(4),
                list.get(5), list.get(9), list.get(13))));
    }
}
