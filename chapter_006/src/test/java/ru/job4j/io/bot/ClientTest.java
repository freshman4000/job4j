package ru.job4j.io.bot;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.hamcrest.core.Is;
import org.mockito.Mockito;

import java.io.*;
import java.net.Socket;

/**
 * Testing class.
 */
public class ClientTest {
    private static final String LN = System.lineSeparator();
    private static final String EXIT = String.format("%s%s%s%s", "bb my friend", LN, "see ya!", LN);
    public InputStream inDef = System.in;
    public PrintStream outDef = System.out;

    public String getResponseFromServer(String in) {
        String result = "";
        try (Socket socket = Mockito.mock(Socket.class);
             ByteArrayInputStream inputStream = new ByteArrayInputStream(in.getBytes());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Server server = new Server(socket);
            Mockito.when(socket.getInputStream()).thenReturn(inputStream);
            Mockito.when(socket.getOutputStream()).thenReturn(outputStream);
            server.start();
            result = outputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void clientTest(String request, String response) {
        try (Socket socket = Mockito.mock(Socket.class);
             ByteArrayInputStream inputStream = new ByteArrayInputStream(getResponseFromServer(request).getBytes());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             ByteArrayOutputStream outputStreamFinal = new ByteArrayOutputStream();
             InputStream inScan = new ByteArrayInputStream(request.getBytes())
        ) {
            System.setIn(inScan);
            Client client = new Client(socket);
            Mockito.when(socket.getInputStream()).thenReturn(inputStream);
            Mockito.when(socket.getOutputStream()).thenReturn(outputStream);
            System.setOut(new PrintStream(outputStreamFinal));
            client.start();
            Assert.assertThat(response, Is.is(outputStreamFinal.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(inDef);
        System.setOut(outDef);
    }

    @Test
    public void whenAskContainsExit() {
        clientTest("exit", EXIT);
    }

    @Test
    public void whenAskContainsHi() {
        clientTest(String.format("%s%s%s", "Hi my friend!", LN, "exit"),
                String.format("%s%s%s", "Hello, dear friend, I'm an Oracle.", LN, EXIT));
    }

    @Test
    public void whenAskContainsHello() {
        clientTest(String.format("%s%s%s", "HELLO ORACle!", LN, "exit"),
                String.format("%s%s%s", "Hello, dear friend, I'm an Oracle.", LN, EXIT));
    }

    @Test
    public void whenAskContainsAsk() {
        clientTest(String.format("%s%s%s", "HELLO ORACle! May I ask You a question?", LN, "exit"),
                String.format("%s%s%s", "You can ask me any question.", LN, EXIT));
    }

    @Test
    public void whenAskContainsWhen() {
        clientTest(String.format("%s%s%s", "When will you come here?", LN, "exit"),
                String.format("%s%s%s", "Only god knows when something is gonna happen!", LN, EXIT));
    }

    @Test
    public void whenAskContainsWhy() {
        clientTest(String.format("%s%s%s", "Why are you here?", LN, "exit"),
                String.format("%s%s%s", "Only god knows why something happens!", LN, EXIT));
    }

    @Test
    public void whenAskContainsWhere() {
        clientTest(String.format("%s%s%s", "Where am I GONNA live IN 5 years?", LN, "exit"),
                String.format("%s%s%s", "I don't know where exactly!", LN, EXIT));
    }

    @Test
    public void whenAskContainsXXX() {
        clientTest(String.format("%s%s%s", "XXX?", LN, "exit"),
                String.format("%s%s%s", "I don't know.", LN, EXIT));
    }
}
