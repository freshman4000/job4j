package ru.job4j.io.exam;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test class.
 */
public class DirectoryInteractiveTest {
    @Test
    public void consTesting() {
        final Shell1 shell = new Shell1();
        Assert.assertThat(shell.path(), Is.is("/"));

        shell.cd("/");
        Assert.assertThat(shell.path(), Is.is("/"));

        shell.cd("usr/..");
        Assert.assertThat(shell.path(), Is.is("/"));

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        Assert.assertThat(shell.path(), Is.is("/usr/local"));

        shell.cd("..");
        Assert.assertThat(shell.path(), Is.is("/usr"));

        shell.cd("//lib///");
        Assert.assertThat(shell.path(), Is.is("/lib"));

        shell.cd("usr").cd("local").cd("system");
        Assert.assertThat(shell.path(), Is.is("/lib/usr/local/system"));

        shell.cd("../..");
        Assert.assertThat(shell.path(), Is.is("/lib/usr"));

        shell.cd("local/system");
        Assert.assertThat(shell.path(), Is.is("/lib/usr/local/system"));

        shell.cd("/");
        Assert.assertThat(shell.path(), Is.is("/"));

        shell.cd("lib/usr/local/system");
        Assert.assertThat(shell.path(), Is.is("/lib/usr/local/system"));
    }
}
