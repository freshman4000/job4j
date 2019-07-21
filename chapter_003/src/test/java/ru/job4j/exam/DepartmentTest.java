package ru.job4j.exam;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;

/**
 * Test class.
 */
public class DepartmentTest {

    /**
     * Testing checkForOccurrences().
     */
    @Test
    public void when2SubDepThen3LinesOfCodes() {
        Department d1 = new Department("K1\\SK1");
        List<String> result = Department.checkerForOccurrences(Department.getCodes());
        List<String> expected = Arrays.asList("K1\\SK1", "K1");
        Assert.assertThat(result, Is.is(expected));
    }

    /**
     * Testing same department input checkForOccurrences().
     */
    @Test
    public void when2SameSubDepThen3LinesOfCodes() {
        Department.getCodes().clear();
        Department d1 = new Department("K1\\SK1");
        Department d2 = new Department("K1\\SK1");
        Department d3 = new Department("K1\\SK1");
        List<String> result1 = Department.checkerForOccurrences(Department.getCodes());
        List<String> expected = Arrays.asList("K1\\SK1", "K1");
        Assert.assertThat(result1, Is.is(expected));
    }

    /**
     * Testing natural order sorting.
     */
    @Test
    public void whenNatSortThenNatOrder() {
        Department d1 = new Department("K1\\SK1");
        Department d2 = new Department("K1\\SK2");
        Department d3 = new Department("K1\\SK1\\SSK1");
        Department d4 = new Department("K1\\SK1\\SSK2");
        Department d5 = new Department("K2");
        Department d6 = new Department("K2\\SK1\\SSK1");
        Department d7 = new Department("K2\\SK1\\SSK2");
        List<String> result2 = Department.sortNat();
        List<String> expected = Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2");
        Assert.assertThat(result2, Is.is(expected));
    }

    /**
     * Testing special reversed order sorting.
     */
    @Test
    public void whenRevSortThenSpecRevOrder() {
        Department d1 = new Department("K1\\SK1");
        Department d2 = new Department("K1\\SK2");
        Department d3 = new Department("K1\\SK1\\SSK1");
        Department d4 = new Department("K1\\SK1\\SSK2");
        Department d5 = new Department("K2");
        Department d6 = new Department("K2\\SK1\\SSK1");
        Department d7 = new Department("K2\\SK1\\SSK2");
        List<String> result3 = Department.sortRev();
        List<String> expected = Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1");
        Assert.assertThat(result3, Is.is(expected));
    }
}
