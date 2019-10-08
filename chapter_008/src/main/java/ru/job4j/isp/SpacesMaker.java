package ru.job4j.isp;

public class SpacesMaker {
    public static String makeSpaces(MenuItem item) {
        String result = "";
        MenuItem cur = item;
        while (cur.getParent() != null) {
            result = result.concat("----");
            cur = cur.getParent();
        }
        return result;
    }
}
