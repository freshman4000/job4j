package ru.job4j.io.bot;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Testing class.
 */
public class ServerTest {
    private static final String LN = System.lineSeparator();
    private static final String EXIT = String.format("%s%s%s%s%s", "bb my friend", LN, "see ya!", LN, LN);

    /**
     * Test method.
     *
     * @param in  incoming data in string format.
     * @param out expected test output in String format.
     */
    public static void serverTest(String in, String out) {
        try (Socket socket = Mockito.mock(Socket.class);
             ByteArrayInputStream inputStream = new ByteArrayInputStream(in.getBytes());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Server server = new Server(socket);
            Mockito.when(socket.getInputStream()).thenReturn(inputStream);
            Mockito.when(socket.getOutputStream()).thenReturn(outputStream);
            server.start();
            Assert.assertThat(outputStream.toString(), Is.is(out));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAskContainsExit() {
        serverTest("exit", String.format("%s", EXIT));
    }

    @Test
    public void whenAskContainsHi() {
        serverTest(String.format("%s%s%s", "Hi my friend!", LN, "exit"),
                String.format("%s%s%s%s", "Hello, dear friend, I'm an Oracle.", LN, LN, EXIT));
    }

    @Test
    public void whenAskContainsHello() {
        serverTest(String.format("%s%s%s", "HELLO ORACle!", LN, "exit"),
                String.format("%s%s%s%s", "Hello, dear friend, I'm an Oracle.", LN, LN, EXIT));
    }

    @Test
    public void whenAskContainsAsk() {
        serverTest(String.format("%s%s%s", "HELLO ORACle! May I ask You a question?", LN, "exit"),
                String.format("%s%s%s%s", "You can ask me any question.", LN, LN, EXIT));
    }

    @Test
    public void whenAskContainsWhen() {
        serverTest(String.format("%s%s%s", "When will you come here?", LN, "exit"),
                String.format("%s%s%s%s", "Only god knows when something is gonna happen!", LN, LN, EXIT));
    }

    @Test
    public void whenAskContainsWhy() {
        serverTest(String.format("%s%s%s", "Why are you here?", LN, "exit"),
                String.format("%s%s%s%s", "Only god knows why something happens!", LN, LN, EXIT));
    }

    @Test
    public void whenAskContainsWhere() {
        serverTest(String.format("%s%s%s", "Where am I GONNA live IN 5 years?", LN, "exit"),
                String.format("%s%s%s%s", "I don't know where exactly!", LN, LN, EXIT));
    }

    @Test
    public void whenAskContainsXXX() {
        serverTest(String.format("%s%s%s", "XXX?", LN, "exit"),
                String.format("%s%s%s%s", "I don't know.", LN, LN, EXIT));
    }
}
