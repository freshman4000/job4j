package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Chat {
    static Scanner sc = new Scanner(System.in);
    private  Map<Integer, String> ready;

    public Chat(String source) {
        this.ready = readFile(source);
    }

    public void start() {
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
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src/main/resources/chat.log")))) {
            pw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<Integer, String> readFile(String source) {
        Map<Integer, String> result = new HashMap<>();
        int counter = -1;
        File file = new File(source);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String curr = br.readLine();
                if (!curr.isEmpty()) {
                    result.put(++counter, curr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public String gPhr() {
        Random rnd = new Random(System.currentTimeMillis());
       return this.ready.get(rnd.nextInt(this.ready.size()));
    }

    public static void main(String[] args) {
        new Chat("chapter_006/src/main/resources/bible.txt").start();
    }
}
