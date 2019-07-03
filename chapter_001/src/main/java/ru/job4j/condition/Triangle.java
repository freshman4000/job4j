package ru.job4j.condition;

/**
 * Class
 */
public class Triangle {
    /**
     * First point of triangle.
     */
    private Point first;
    /**
     * Second point of triangle.
     */
    private Point second;
    /**
     * Third point of triangle.
     */
    private Point third;
    /**
     * Constructor of Triangle.
     * @param ap first point.
     * @param bp second point.
     * @param cp third point.
     */
    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * Формула.
     *
     * (a + b + c) / 2
     *
     * @return half-perimeter.
     */
    public double period() {
        double a = this.first.distance(this.second);
        double b = this.second.distance(this.third);
        double c = this.first.distance(this.third);
        return (a + b + c) / 2;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @return type boolean
     */
    private boolean exist() {
        double a = this.first.distance(this.second);
        double b = this.second.distance(this.third);
        double c = this.first.distance(this.third);
        return a + c > b && a + b > c && c + b > a;
    }
    /**
     * Метод должен вычислить площадь треугольника.
     *
     * Формула.
     *
     * √ p *(p - a) * (p - b) * (p - c)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double result = -1;
        double a = this.first.distance(this.second);
        double b = this.second.distance(this.third);
        double c = this.first.distance(this.third);
        double p = this.period();
        if (this.exist()) {
            result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return result;
    }
}