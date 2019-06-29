package ru.job4j.loop;

/**
 * Class Paint creates string that looks like pyramid if printed.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 29.06.2019.
 */
public class Paint {
    /**
     * Method forms string.
     * @param height of the pyramid.
     * @return String object.
     */
    public String pyramid(int height) {
        StringBuilder sb = new StringBuilder();
        String ln = System.lineSeparator();
        int width = height * 2 - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= Math.abs(height - 1 - column)) {
                    sb.append("^");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(ln);
        }
        return sb.toString();
    }
}