package ru.job4j.tdd;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is responsible for generating new string from incoming string, by
 * substituting regex values in string by keys from key-map corresponding to those
 * regex patterns.
 */
public class StringGenerator implements Generator<String> {

    private String string;
    private Map<String, String> keys;
    private final Pattern pattern = Pattern.compile("(\\$\\{[^${}]*}\\$)");

    public StringGenerator(String string, Map<String, String> keys) {
        this.keys = keys;
        this.string = string;
    }

    /**
     * This method first checks if number of distinct keys in key-map and in incoming string match. If - not,
     * it throws corresponding exception. After that it finds places in string matching regex and substitutes
     * them by corresponding values from key-map, provided in constructor in moment of creation of
     * class object.
     *
     * @return new String value.
     * @throws KeyDiffException       key diff exception.
     * @throws NoKeyPresenceException no key in list exception.
     */
    @Override
    public String generate() throws KeyDiffException, NoKeyPresenceException {
        Validator validator = new KeyNumberMatchValidator(string, keys, pattern);
        if (!validator.validate()) {
            throw new KeyDiffException("Number of distinct keys in key-map and in incoming string don't match");
        }
        Matcher m = pattern.matcher(string);
        while (m.find()) {
            String currentMatch = m.group();
            String key = currentMatch.substring(2, currentMatch.length() - 2);
            validator = new KeyPresenceValidator(key, keys);
            if (!validator.validate()) {
                throw new NoKeyPresenceException("Keys in key-map and in incoming string don't match");
            }
            string = string.replace(currentMatch, keys.get(key));
        }
        return string;
    }
}
