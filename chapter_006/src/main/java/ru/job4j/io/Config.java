package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            while (br.ready()) {
                String buff = br.readLine();
                if (!buff.equals("") && !buff.startsWith("#") && !buff.startsWith("//") && !buff.startsWith("/**")) {
                    values.put(buff.split("=")[0], buff.split("=")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public String value(String key) {
        return values.get(key);
    }
}
