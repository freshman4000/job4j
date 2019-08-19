package ru.job4j.io.bot;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner console = new Scanner(System.in);
            String ask;
            do {
                ask = console.nextLine();
                out.println(ask);
                String str;
                while (true) {
                    str = in.readLine();
                    if (str.isEmpty()) {
                        break;
                    }
                    System.out.println(str);
                }
            } while (!ask.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4004)) {
            new Client(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
