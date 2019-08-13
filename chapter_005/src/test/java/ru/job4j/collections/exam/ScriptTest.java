package ru.job4j.collections.exam;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;

/**
 * Test.
 */
public class ScriptTest {
    @Test
    public void when1Then445() {
        Script script = new Script("1-[2,3],2-[4],3-[4,5],4-[],5-[]");
        List<Integer> expected = Arrays.asList(4, 4, 5);
        List<Integer> result = Script.load(script.mapLoader(), 1);
        Assert.assertThat(expected, Is.is(result));
    }

    @Test
    public void when2Then4() {
        Script script = new Script("1-[2,3],2-[4],3-[4,5],4-[],5-[]");
        List<Integer> expected = Arrays.asList(4);
        List<Integer> result = Script.load(script.mapLoader(), 2);
        Assert.assertThat(expected, Is.is(result));
    }

    @Test
    public void when3Then45() {
        Script script = new Script("1-[2,3],2-[4],3-[4,5],4-[],5-[]");
        List<Integer> expected = Arrays.asList(4, 5);
        List<Integer> result = Script.load(script.mapLoader(), 3);
        Assert.assertThat(expected, Is.is(result));
    }

    @Test
    public void when4ThenEmpty() {
        Script script = new Script("1-[2,3],2-[4],3-[4,5],4-[],5-[]");
        List<Integer> expected = Arrays.asList();
        List<Integer> result = Script.load(script.mapLoader(), 4);
        Assert.assertThat(expected, Is.is(result));
    }

    /**
     * Testing "1-[2,3],2-[4],3-[4,5],4-[5],5-[]".
     */
    @Test
    public void when1Then555() {
        Script script = new Script("1-[2,3],2-[4],3-[4,5],4-[5],5-[]");
        List<Integer> expected = Arrays.asList(5, 5, 5);
        List<Integer> result = Script.load(script.mapLoader(), 1);
        Assert.assertThat(expected, Is.is(result));
    }

    /**
     * Testing "1-[2,3,3,2],2-[4],3-[4,5],4-[],5-[]".
     */
    @Test
    public void when1Then445454() {
        Script script = new Script("1-[2,3,3,2],2-[4],3-[4,5],4-[],5-[]");
        List<Integer> expected = Arrays.asList(4, 4, 5, 4, 5, 4);
        List<Integer> result = Script.load(script.mapLoader(), 1);
        Assert.assertThat(expected, Is.is(result));
    }
}
