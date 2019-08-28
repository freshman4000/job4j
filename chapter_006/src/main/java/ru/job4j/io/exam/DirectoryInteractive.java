package ru.job4j.io.exam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Class that simulates windows cmd behavior in part of directories navigation. Notice that
 * "exit" exits program as well. Also there is difference between this cmd emulator and win cmd. In
 * this "mini cmd" two backslashes "//" return us to the root of mentioned web device, other words -
 * this cmd accepts UNC paths.
 * Program can be compiled by javac DirectoryInteractive.java.
 * After compilation it can be run by the command: java path_to_compiled_file. In this version -ea option is not
 * used - because assertion was made in DirectoryInteractiveTest.
 */
class Shell1 {
    private static String curPath = "/";

    public Shell1 cd(final String path) {
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
            curPath = buf.length <= 2 ? "/" : Arrays.stream(buf).limit(buf.length - 1).collect(Collectors.joining("/"));
        }
        if (path.trim().toLowerCase().matches("(//)([a-zA-Z\\d]+)([/]+?)")) {
            curPath = "/" + path.replaceAll("[/\\\\]", "");
        }
        if (path.trim().toLowerCase().matches("(\\.\\.)([/\\\\])(\\.\\.)")) {
            String[] buf = curPath.split("/");
            curPath = buf.length <= 3 ? "/" : Arrays.stream(buf).limit(buf.length - 2).collect(Collectors.joining("/"));
        }

        return this;
    }

    public String path() {
        return curPath;
    }
}

public class DirectoryInteractive {

    public static void main(String[] args) {

        final Shell1 shell = new Shell1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = shell.path();
            shell.cd(sc.nextLine());
            System.out.println(s.equals(shell.path()) && !s.equals("/") ? "no such command" : shell.path());
        }
    }
}