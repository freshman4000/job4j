package ru.job4j.calculator;
/**
 * class Calculator for simple arithmetic operations
 * @author Vit Efremov
 * @since 28.06.2019
 * @version 1
 */
public class Calculator {
    /**
     * Method add does addition of parameters
     * @param first number type double
     * @param second number type double
     * @return sum of first and second parameters type double
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     * Method subtract does subtraction between parameters
     * @param first number type double
     * @param second number type double
     * @return difference between first and second parameters type double
     */
    public double subtract(double first, double second) {
        return first - second;
    }
    /**
     * Method div does division of parameters
     * @param first number type double
     * @param second number type double
     * @return quotient of first param (dividend) by second param(divisor) type double
     */
    public double div(double first, double second) {
        return first / second;
    }
    /**
     * Method multiply does multiplication of parameters
     * @param first number type double
     * @param second number type double
     * @return product of first param multiplied by second param type double
     */
    public double multiply(double first, double second) {
        return first * second;
    }
}
