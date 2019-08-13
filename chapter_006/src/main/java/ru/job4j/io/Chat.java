package ru.job4j.io;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Chat {
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        String current = "";
        StringBuilder sb = new StringBuilder("");
        boolean flag = true;
        while (!current.equals("end")) {
            current = sc.nextLine();
            sb.append(current).append(System.lineSeparator());
            if (current.equals("stop")) {
                flag = false;
            }
            if (current.equals("continue")) {
                flag = true;
            }
            if (flag && !current.equals("end")) {
                String phrase = gPhr();
                sb.append(phrase).append(System.lineSeparator());
                System.out.println(phrase);
            }
            if (current.equals("end")) {
                wLog(sb.toString());
            }
        }
    }

    public static void wLog(String s) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\chat.log")))) {
            pw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String gPhr() {
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\bible.txt"))) {
            Random rnd = new Random(System.currentTimeMillis());
            String line = "";
            while (line.equals("")) {
                line = br.lines().skip(rnd.nextInt(100000)).collect(Collectors.joining());
            }
            result = line.substring(line.indexOf(" ", 0), line.indexOf(".", 100));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        Chat.start();
    }
}
