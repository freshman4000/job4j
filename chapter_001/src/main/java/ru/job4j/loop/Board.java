package ru.job4j.loop;

/**
 * Class Board forms String object that visually looks like
 * chess board consisted of "X"(stands for black cells) ans
 * whitespaces (stands for white cells).
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 29.06.2019.
 * @version 1.0.
 */
public class Board {
    /**
     * Forms String object
     * @param width type int
     * @param height type int
     * @return String object
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        screen.append("x");
                    } else {
                        screen.append(" ");
                    }
                }
                if (i % 2 > 0) {
                    if (j % 2 == 0) {
                        screen.append(" ");
                    } else {
                        screen.append("x");
                    }
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
