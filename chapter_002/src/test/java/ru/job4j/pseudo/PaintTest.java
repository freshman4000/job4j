package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.out.println("before test");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("After test");
    }
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++\n\r")
                                .append("+  +\n\r")
                                .append("+  +\n\r")
                                .append("++++\n\r")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
        @Test
        public void whenDrawTriangle() {
            new Paint().draw(new Triangle());
            assertThat(
                    new String(out.toByteArray()),
                    is(
                            new StringBuilder()
                                    .append("   +\n\r")
                                    .append("  + +\n\r")
                                    .append(" +   +\n\r")
                                    .append("+++++++\n\r")
                                    .append(System.lineSeparator())
                                    .toString()
                    )
            );
        }
}
