package ru.job4j.pseudo;

/**
 * Class that draws triangle.
 */
public class Triangle implements Shape{
    /**
     * Draws triangle.
     * @return string in shape of triangle.
     */
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append("   +\n\r");
        sb.append("  + +\n\r");
        sb.append(" +   +\n\r");
        sb.append("+++++++\n\r");
        return sb.toString();
    }
}
