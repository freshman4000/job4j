package ru.job4j.io.bot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private Socket socket;
    private Map<String, String> dict;
    private final String phrases = "hi=Hello, dear friend, I'm an Oracle.;hello=Hello, dear friend, I'm an Oracle.;"
            + "ask=You can ask me any question.;when=Only god knows when something is gonna happen!;where=I don't know where "
            + "exactly!;why=Only god knows why something happens!";

    public Server(Socket socket) {
        this.socket = socket;
        this.dict = initDict();
    }

    public Socket getSocket() {
        return socket;
    }

    private Map<String, String> initDict() {
        Map<String, String> result = new HashMap<>();
        Arrays.stream(phrases.split(";")).forEach(x -> result.put(x.split("=")[0], x.split("=")[1]));
        return result;
    }

    public void start() {
        boolean gotAnswer = false;
        try (
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        ) {
            String ask;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                for (String s : dict.keySet()) {
                    if (ask.toLowerCase().contains(s)) {
                        out.println(dict.get(s));
                        out.println();
                        gotAnswer = true;
                        break;
                    }
                }
                if (!"exit".equals(ask.toLowerCase()) && !gotAnswer) {
                    out.println("I don't know.");
                    out.println();
                } else if ("exit".equals(ask.toLowerCase())) {
                    out.println("bb my friend");
                    out.println("see ya!");
                    out.println();
                }
                gotAnswer = false;
            } while (!"exit".equals(ask));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        try (Socket socket = new ServerSocket(4004).accept()) {
            new Server(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
