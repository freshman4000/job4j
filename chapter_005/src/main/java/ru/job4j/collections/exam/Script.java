package ru.job4j.collections.exam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class that accepts string of scripts and returns (if required) - the needed sequence of scripts to
 * achieve specified script result.
 */
public class Script {
    private String scriptLine;
    private Map<Integer, List<Integer>> ds;

    public Script(String scriptLine) {
        this.scriptLine = scriptLine;
        this.ds = mapLoader();
    }

    public static List<Integer> load(Map<Integer, List<Integer>> map, Integer stringId) {
        List<Integer> result = map.containsKey(stringId) ? map.get(stringId) : new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        if (!result.isEmpty()) {
            q.offer(stringId);
            while (!q.isEmpty()) {
                int cur = q.poll();
                buffer.add(cur);
                if (!map.get(cur).isEmpty()) {
                    q.addAll(map.get(cur));
                }
            }
            result = buffer.stream().filter(x -> map.get(x).isEmpty()).collect(Collectors.toList());
        }
        return result;
    }

    /**
     * Transforms input string of scripts into Map, where key is key of script and value - is List of script keys,
     * which are needed to start current script.
     *
     * @return map.
     */
    public Map<Integer, List<Integer>> mapLoader() {
        Pattern pattern = Pattern.compile("\\d-\\[(\\d)?(,\\d)*?\\]");
        Matcher matcher = pattern.matcher(scriptLine);
        Map<Integer, List<Integer>> result = new HashMap<>();
        String[] buff;
        while (matcher.find()) {
            String s = matcher.group();
            buff = s.split("-");
            List<Integer> lst = buff[1].chars()
                    .filter(Character::isDigit)
                    .map(Character::getNumericValue)
                    .boxed()
                    .collect(Collectors.toList());
            result.put(Integer.parseInt(buff[0]), lst);
        }
        return result;
    }
}