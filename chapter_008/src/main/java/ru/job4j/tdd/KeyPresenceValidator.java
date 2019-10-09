package ru.job4j.tdd;

import java.util.Map;

/**
 * This class is responsible for data validation.
 */
public class KeyPresenceValidator implements Validator {
    private String key;
    private Map<String, String> keys;

    public KeyPresenceValidator(String key, Map<String, String> keys) {
        this.key = key;
        this.keys = keys;
    }

    /**
     * This method validates if map-key list contains regex key from incoming string.
     * @return boolean value.
     */
    @Override
    public boolean validate() {
        return keys.containsKey(key);
    }
}
