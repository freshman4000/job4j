package ru.job4j.calculate;

/** 
*Class Calculate for console output of exact text phrase "Hello World"
*@author Vit Efremov (freshman4000@gmail.com)
*@since 26.06.2019
*@version 1.0
*/
public class Calculate {
	/**
	 *Method main entrance point of class and application
	 *@param args string array of incoming argument values
	*/
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	/**
 * Method echo.
 * @param name Your name.
 * @return Echo plus your name.
 */
 public String echo(String name) {
    return "Echo, echo, echo : " + name;
 }
}