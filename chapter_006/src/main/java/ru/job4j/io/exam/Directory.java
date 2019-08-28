package ru.job4j.io.exam;
/*
 * Please solve the following puzzle which simulates generic directory structures.
 * The solution should be directory agnostic.
 * Be succinct yet readable. You should not exceed more than 200 lines.
 * Consider adding comments and asserts to help the understanding.
 * Code can be compiled with javac Directory.java
 * Code should be executed as: java -ea Directory (-ea option it's to enable the assert)
 */
    /*
    exit - exits cmd.
    cd / - returns to the root.
    cd folder_name - goes 1 folder down.
    cd .. - goes 1 folder up. (can be followed with any quantity of Fwd slashes or Bck slashes).
    cd../.. - goes 2 folders up(if there are less than 2 folders upper - goes to the root).
    cd //folder_name - goes to UNC device root.
     */

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * change the code here.
 */
class Shell {
    private static String curPath = "/";

    Shell cd(final String path) {
        if (path.equals("exit")) {
            System.exit(0);
        }
        if (path.trim().equals("/")) {
            curPath = "/";
        }
        if (path.trim().toLowerCase().matches("[a-zA-Z\\d]+")
                || path.trim().toLowerCase().matches("([a-zA-Z\\d]+/)+([a-zA-Z\\d]+)")) {
            curPath = curPath.endsWith("/") ? curPath.concat(path.trim().toLowerCase())
                    : curPath.concat("/").concat(path.trim().toLowerCase());
        }
        if (path.trim().toLowerCase().matches("(\\.\\.)([/\\\\]+)?")) {
            String[] buf = curPath.split("/");
            curPath = Arrays.stream(buf).limit(buf.length - 1).collect(Collectors.joining("/"));
        }
        if (path.trim().toLowerCase().matches("(//)([a-zA-Z\\d]+)([/]+?)")) {
            curPath = "/" + path.replaceAll("[/\\\\]", "");
        }
        if (path.trim().toLowerCase().matches("(\\.\\.)([/\\\\])(\\.\\.)")) {
            String[] buf = curPath.split("/");
            curPath = buf.length <= 2 ? "/" : Arrays.stream(buf).limit(buf.length - 2).collect(Collectors.joining("/"));
        }

        return this;
    }

    public String path() {
        return curPath;
    }
}

public class Directory {

    public static void main(String[] args) {

        final Shell shell = new Shell();
        assert shell.path().equals("/");

        shell.cd("/");
        System.out.println(shell.path());
        assert shell.path().equals("/");

        shell.cd("usr/..");
        System.out.println(shell.path());
        assert shell.path().equals("/");

        shell.cd("usr").cd("local");
        System.out.println(shell.path());
        shell.cd("../local").cd("./");
        System.out.println(shell.path());
        assert shell.path().equals("/usr/local");

        shell.cd("..");
        System.out.println(shell.path());
        assert shell.path().equals("/usr");

        shell.cd("//lib///");
        System.out.println(shell.path());
        assert shell.path().equals("/lib");

        shell.cd("usr").cd("local").cd("system");
        System.out.println(shell.path());
        assert shell.path().equals("/lib/usr/local/system");

        shell.cd("../..");
        System.out.println(shell.path());
        assert shell.path().equals("/lib/usr");

        shell.cd("local/system");
        System.out.println(shell.path());
        assert shell.path().equals("/lib/usr/local/system");

        shell.cd("/");
        System.out.println(shell.path());
        assert shell.path().equals("/");

        shell.cd("lib/usr/local/system");
        System.out.println(shell.path());
        assert shell.path().equals("/lib/usr/local/system");
    }
}
