package ru.job4j.phonebook;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.List;

/**
 * Test.
 */
public class PhoneDictionaryTest {
    /**
     * Testing addition and searching.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        Assert.assertThat(persons.iterator().next().getSurname(), Is.is("Arsentev"));
    }
}