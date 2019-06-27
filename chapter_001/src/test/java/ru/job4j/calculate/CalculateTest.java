package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test.
 *
 *@author Vit Efremov (freshman4000@gmail.com)
 *@since 27.06.2019
 *@version 1.0
 */
public class CalculateTest {
	/**
	 *Test echo.
	 */

	@Test
	public void whenTakeNameThenThreeEchosPlusName() {
		String input = "Vit Efremov";
		String expect = "Echo, echo, echo : Vit Efremov";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}