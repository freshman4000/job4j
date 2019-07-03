package ru.job4j.condition;

/**
 * class Point calculates distance between two points.
 * @author Vit Efremov.
 * @since 28.06.2019.
 * @version 1.2.
 */
public class Point {
    /**
     * x coordinate.
     */
    private int x;
    /**
     * y coordinate.
     */
    private int y;
    /**
     * z coordinate.
     */
    private int z;
    /**
     * Constructor
     * @param first x coordinate.
     * @param second y coordinate.
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    /**
     * Overloaded Constructor
     * @param first x coordinate.
     * @param second y coordinate.
     * @param third z coordinate.
     */
    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }
        /**
     * Method distance.
     * @param that class Point object to which distance is calculated.
     * @return distance between this point and that point.
     */
        public double distance(Point that) {
        double first = Math.pow(this.x - that.x, 2);
        double second = Math.pow(this.y - that.y, 2);
        return Math.sqrt(first + second);
    }
    /**
     * Method distance in 3d.
     * @param that class Point object to which distance is calculated.
     * @return distance between this point and that point.
     */
    public double distance3d(Point that) {
        double first = Math.pow(this.x - that.x, 2);
        double second = Math.pow(this.y - that.y, 2);
        double third = Math.pow(this.z - that.z, 2);
        return Math.sqrt(first + second + third);
    }
    /**
     * Method info shows coordinates of the point in 2d.
     */
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
    /**
     * Method info shows coordinates of the point in 3d.
     */
    public void info3d() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }
}