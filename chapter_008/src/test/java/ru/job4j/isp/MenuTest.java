package ru.job4j.isp;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Testing menu.
 */
public class MenuTest {
    @Test
    public void when2TasksFirstWith2LvsSecWith1LvlThenAllSeparatedInGroups() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Menu menu = new Menu(new ArrayList<>());
        MenuItem item1 = new MenuItem("1 Task", null, new ArrayList<>());
        MenuItem item11 = new MenuItem("1.1 Task", null, new ArrayList<>());
        MenuItem item12 = new MenuItem("1.2 Task", null, new ArrayList<>());
        item1.addChild(item11, item12);
        item11.addParent(item1);
        item12.addParent(item1);
        MenuItem item111 = new MenuItem("1.1.1 Task", null, new ArrayList<>());
        MenuItem item112 = new MenuItem("1.1.2 Task", null, new ArrayList<>());
        item11.addChild(item111, item112);
        item111.addParent(item11);
        item112.addParent(item11);
        MenuItem item121 = new MenuItem("1.2.1 Task", null, new ArrayList<>());
        MenuItem item122 = new MenuItem("1.2.2 Task", null, new ArrayList<>());
        item12.addChild(item121, item122);
        item121.addParent(item12);
        item122.addParent(item12);
        MenuItem item2 = new MenuItem("2 Task", null, new ArrayList<>());
        MenuItem item21 = new MenuItem("2.1 Task", null, new ArrayList<>());
        MenuItem item22 = new MenuItem("2.2 Task", null, new ArrayList<>());
        MenuItem item23 = new MenuItem("2.3 Task", null, new ArrayList<>());
        item2.addChild(item21, item22, item23);
        item21.addParent(item2);
        item22.addParent(item2);
        item23.addParent(item2);
        menu.add(item1);
        menu.add(item2);
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
}
