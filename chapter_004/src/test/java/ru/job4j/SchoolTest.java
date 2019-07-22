package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.*;

/**
 * Test.
 */
public class SchoolTest {

    Student s1 = new Student(99, "Vit", "Efr");
    Student s2 = new Student(23, "Aj", "Barret");
    Student s3 = new Student(76, "Cj", "Money");
    Student s4 = new Student(48, "El", "Crispy");
    Student s5 = new Student(87, "Melony", "Hawkins");
    Student s6 = new Student(88, "Andrew", "Stein");
    Student s7 = new Student(35, "Max", "Levandowsky");
    Student s8 = new Student(18, "Ann", "Smith");
    Student s9 = new Student(66, "Gerbert", "Stern");
    Student s10 = new Student(100, "Mark", "O'polo");
    Student s11 = new Student(12, "Satoshi", "Nakamoto");
    Student s12 = new Student(32, "Daniel", "Larimer");
    Student s13 = new Student(0, "Charles", "Hoskinnson");
    Student s14 = new Student(72, "Justin", "Sun");
    Student s15 = new Student(56, "Changpeng", "Zhao");
    Student s16 = new Student(41, "Ariel", "Ling");
    List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16);

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

    /**
     * Testing map creation from the list of students.
     */
    @Test
    public void when5StudThen5KeySetsInMap() {
        Map<String, Student> result = School.formMap(list);
        Map<String, Student> expected = new HashMap<>();
        for (Student std : list) {
            expected.put(std.getLastName(), std);
        }
        Assert.assertThat(result, Is.is(expected));
    }
}
