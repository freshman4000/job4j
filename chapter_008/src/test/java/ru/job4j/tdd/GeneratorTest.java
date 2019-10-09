package ru.job4j.tdd;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Testing class.
 */
public class GeneratorTest {
    /**
     * Testing one key.
     */
    @Test
    public void whenStringWithPatternKeysThenGetStringWithSubstitutedPatternsByKeyValues() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        Pattern pattern = Pattern.compile("(\\$\\{[^${}]*}\\$)");
        Generator<String> generator = new StringGenerator("Hi, my name is ${name}$", map, pattern);
        String result = "";
        try {
            result = generator.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertThat(result, Is.is("Hi, my name is Petr"));
    }

    /**
     * Testing several keys.
     */
    @Test
    public void whenStringWithPatternKeysThenGetStringWithSubstitutedPatternsByKeyValues2() {
        Map<String, String> map = new HashMap<>();
        map.put("sos", "Aaaa");
        Pattern pattern = Pattern.compile("(\\$\\{[^${}]*}\\$)");
        Generator<String> generator = new StringGenerator("Help, ${sos}$, ${sos}$, ${sos}$", map, pattern);
        String result = "";
        try {
            result = generator.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertThat(result, Is.is("Help, Aaaa, Aaaa, Aaaa"));
    }

    /**
     * Testing key no presence.
     */
    @Test(expected = NoKeyPresenceException.class)
    public void whenKeysNotPresentThenException() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("sod", "Aaaa");
        Pattern pattern = Pattern.compile("(\\$\\{[^${}]*}\\$)");
        Generator<String> generator = new StringGenerator("Help, ${sos}$, ${sos}$, ${sos}$", map, pattern);
        String result = "";
        result = generator.generate();
    }

    /**
     * Testing key numbers difference.
     */
    @Test(expected = KeyDiffException.class)
    public void whenKeysNumDoNotMatchPresentThenException() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("sos", "Aaaa");
        map.put("name", "Petr");
        Pattern pattern = Pattern.compile("(\\$\\{[^${}]*}\\$)");
        Generator<String> generator = new StringGenerator("Help, ${sos}$, ${sos}$, ${sos}$", map, pattern);
        String result = "";
        result = generator.generate();
    }
}