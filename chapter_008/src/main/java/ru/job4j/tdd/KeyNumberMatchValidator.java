package ru.job4j.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * THis class is responsible for validation of data.
 */
public class KeyNumberMatchValidator implements Validator {
    private String string;
    private Map<String, String> keys;
    private Pattern pattern;

    public KeyNumberMatchValidator(String string, Map<String, String> keys, Pattern pattern) {
        this.string = string;
        this.keys = keys;
        this.pattern = pattern;
    }

    /**
     * This method validates if number of distinct keys, matches the number of distinct values in incoming string, that
     * are ready for substitution.
     * @return boolean value.
     */
    @Override
    public boolean validate() {
        Matcher m = pattern.matcher(string);
        List<String> matches = new ArrayList<>();
        while (m.find()) {
            matches.add(m.group());
        }
        return matches.stream().distinct().count() == keys.size();
    }
}
