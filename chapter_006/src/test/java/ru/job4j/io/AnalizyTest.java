package ru.job4j.io;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalizyTest {
    @Test
    public void whenDownTimeThenWriteDownTime() {
        Analizy analizy = new Analizy();
        analizy.unavailable("src/main/resources/server.log",
                "unavaliable.csv");
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/unavaliable.csv"))) {
            Assert.assertThat(br.readLine(), Is.is("10:58:01;10:59:01"));
            Assert.assertThat(br.readLine(), Is.is("11:01:02;11:02:02"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
