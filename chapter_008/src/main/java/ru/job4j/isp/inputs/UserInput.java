package ru.job4j.isp.inputs;

import java.util.Scanner;

public class UserInput implements Input {
    @Override
    public String getInput() {
        return new Scanner(System.in).nextLine();
    }
}
