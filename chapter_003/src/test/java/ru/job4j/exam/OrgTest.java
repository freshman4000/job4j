package ru.job4j.exam;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;

public class OrgTest {
    Org.Dept d1 = new Org.Dept("K1");
    Org.Dept d2 = new Org.Dept("K1/SK1");
    Org.Dept d3 = new Org.Dept("K1/SK1/SSK1");
    Org.Dept d4 = new Org.Dept("K1/SK1/SSK2");
    Org.Dept d5 = new Org.Dept("K1/SK2");
    Org.Dept d6 = new Org.Dept("K2");
    Org.Dept d7 = new Org.Dept("K2/SK1");
    Org.Dept d8 = new Org.Dept("K2/SK1/SSK1");
    Org.Dept d9 = new Org.Dept("K2/SK1/SSK2");
    Org org = new Org();
    /**
     * Natural order sort check.
     */
    @Test
    public void whenNatOrderThenFromUpToBottom() {
        org.setList(Arrays.asList(d1, d9, d3, d2, d4, d8, d6, d7, d5));
        List<Org.Dept> expected = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9);
        org.getListOfDept().sort(org.nat);
        Assert.assertThat(org.getListOfDept(), Is.is(expected));
    }
    /**
     * Descending order sort check.
     */
    @Test
    public void whenDescOrderThenFromBottomToTop() {
        org.setList(Arrays.asList(d1, d9, d3, d2, d4, d8, d6, d7, d5));
        List<Org.Dept> expected = Arrays.asList(d6, d7, d9, d8, d1, d5, d2, d4, d3);
        org.getListOfDept().sort(org.rev);
        Assert.assertThat(org.getListOfDept(), Is.is(expected));
    }
}
