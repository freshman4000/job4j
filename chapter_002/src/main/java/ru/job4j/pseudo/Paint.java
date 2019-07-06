package ru.job4j.pseudo;

/**
 * Class Paint prints different shapes to console.
 */
public class Paint {
    /**
     * Prints specified shape to console.
     * @param shape of figure.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Method main.
     * @param args - array of incoming args.
     */
    public static void main(String[] args) {
     new Paint().draw(new Square());
    }
}
