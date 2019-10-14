package ru.job4j.isp;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.isp.inputs.BulkInput;
import ru.job4j.isp.menus.Menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Testing menu.
 */
public class MenuTest {

    private Menu menu = new Menu();


    @Test
    public void when2TasksFirstWith2LvsSecWith1LvlThenAllSeparatedInGroups() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        menu.init();
        menu.show();
        String expected =
                "1 Task" + System.lineSeparator()
                        + "----1.1 Task" + System.lineSeparator()
                        + "--------1.1.1 Task" + System.lineSeparator()
                        + "--------1.1.2 Task" + System.lineSeparator()
                        + "----1.2 Task" + System.lineSeparator()
                        + "--------1.2.1 Task" + System.lineSeparator()
                        + "--------1.2.2 Task" + System.lineSeparator()
                        + "2 Task" + System.lineSeparator()
                        + "----2.1 Task" + System.lineSeparator()
                        + "----2.2 Task" + System.lineSeparator()
                        + "----2.3 Task" + System.lineSeparator();

        Assert.assertThat(out.toString(), Is.is(expected));
        System.setOut(stdOut);
    }

    @Test
    public void whenAction23ThenPrintAction23() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        menu.init();
        new StartUI(menu, new BulkInput(new String[]{"2.3", "exit"})).start();
        String expected = "Choose action or type \"exit\":" + System.lineSeparator()
                + "1 Task" + System.lineSeparator()
                + "----1.1 Task" + System.lineSeparator()
                + "--------1.1.1 Task" + System.lineSeparator()
                + "--------1.1.2 Task" + System.lineSeparator()
                + "----1.2 Task" + System.lineSeparator()
                + "--------1.2.1 Task" + System.lineSeparator()
                + "--------1.2.2 Task" + System.lineSeparator()
                + "2 Task" + System.lineSeparator()
                + "----2.1 Task" + System.lineSeparator()
                + "----2.2 Task" + System.lineSeparator()
                + "----2.3 Task" + System.lineSeparator()
                + "Action on Task 2.3" + System.lineSeparator() + System.lineSeparator();

        Assert.assertThat(out.toString(), Is.is(expected));
        System.setOut(stdOut);
    }
}
