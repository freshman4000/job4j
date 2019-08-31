package ru.job4j.io.find;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

/**
 * 1. Создать программу для поиска файла.
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 * Ключи
 * -d - директория в которая начинать поиск.
 * -n - имя файл, маска, либо регулярное выражение.
 * -m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 */
public class FileSearcher implements FileVisitor<Path> {
    private String fileName;
    private Path source;
    private static List<String> searchResult = new LinkedList<>();

    public FileSearcher(String fileName, Path source) {
        this.fileName = fileName;
        this.source = source;
    }
    private static String[] validateArgs(String[] args) {
        if (args.length < 6) {
            System.out.println("Missing some incoming arguments! Let's fix that!!!");
            System.exit(0);
        }
        if (args[0] == null || !args[0].equals("-d")) {
              args[0] = userInteraction(new String[]{"-d"}, 0);

        }
        if (args[2] == null || !args[2].equals("-n")) {
           args[2] = userInteraction(new String[]{"-n"}, 2);
        }
        if (args[4] == null || (!args[4].equals("-m") && !args[4].equals("-f") && !args[4].equals("-r"))) {
           args[4] = userInteraction(new String[]{"-m", "-f", "-r"}, 4);
        }
        if (args[5] == null || !args[5].equals("-o")) {
           args[5] = userInteraction(new String[]{"-o"}, 5);
        }
        if (!args[3].matches("[*\\w]+\\.[*\\w]+")) {
            Scanner sc = new Scanner(System.in);
            String mess = ("So the file you are looking for should consist of alphanumeric characters!" + System.lineSeparator()
            + "Input whole file name or mask name consisted of alphanumeric characters or \"*\", with one dot inside");
        String fileSearch = "";
            while (!fileSearch.matches("[*\\w]+\\.[*\\w]+")) {
                System.out.println(mess);
                fileSearch = sc.nextLine();
            }
            args[3] = fileSearch;
        }
        Path[] paths = resolvePaths(args[1], args[6]);
        Scanner sc = new Scanner(System.in);
        while (!Files.isDirectory(paths[0])) {
            System.out.println("So the directory you gave in params doesn't exist! Input existing directory for search!!!");
            args[1] = sc.nextLine();
           paths = resolvePaths(args[1], args[6]);
        }
        return args;
    }
    private static String userInteraction(String[] neededParam, int param) {
        boolean gotIt = false;
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        System.out.println("Ok. So your " + param + "th(nd) parameter is wrong. It should match one of those \":");
        Arrays.stream(neededParam).forEach(System.out::println);
        System.out.println("Type it and we'll continue. If tou want to exit - type \"exit\"!");
        while (!gotIt) {
            userInput = sc.nextLine();
            if (userInput.equals("exit")) {
                System.out.println("See ya later!!!");
                System.exit(0);
            }
            for (int i = 0; i < neededParam.length; i++) {
                if (userInput.matches(neededParam[i])) {
                    gotIt = true;
                }
            }
            if (!gotIt) {
                System.out.println("Still wrong! Try one more time please!");
            }
        }
        return userInput;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fName = file.getFileName().toString();
        String neededFileName = fileName.replaceAll("\\.", "\\\\.").replaceAll("\\*", "[\\\\w]+");
        if (fName.matches(neededFileName)) {
            searchResult.add(file.getParent() + "/" + file.getFileName().toString() + System.lineSeparator());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Failed to access file: " + file.toString());
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        boolean finishedSearch = Files.isSameFile(dir, source);
        if (finishedSearch) {
            return TERMINATE;
        }
        return CONTINUE;
    }
    public static Path[] resolvePaths(String source, String destination) {
        Path startingDir = Paths.get(source);
        Path destPath = Paths.get(System.getProperty("user.dir") + "/" + destination);
        return new Path[]{startingDir, destPath};
    }
    public static void writeResultToFile(Path destination) {
        Path file;
            try (PrintWriter out = new PrintWriter(new File(destination.toString()))) {
                if (searchResult.isEmpty()) {
                    out.write("No files found!");
                } else {
                    out.write("Following files were found during search: " + System.lineSeparator());
                    for (String s : searchResult) {
                        out.write(s);
                    }
                }
                out.flush();
            } catch (IOException z) {
                z.printStackTrace();
            }
    }
    public static void main(String[] args) throws IOException {
        String[]args1 = validateArgs(args);
        Path[] paths = resolvePaths(args1[1], args1[6]);
        FileSearcher visitor = new FileSearcher(args1[3], paths[0]);
        Files.walkFileTree(paths[0], visitor);
        writeResultToFile(paths[1]);
        System.out.println("The result of your search is in file, located in: " + paths[1].toString());
    }
}
