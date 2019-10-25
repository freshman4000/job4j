package ru.job4j.services.inputservices;

import java.util.Scanner;

/**
 * Class that asks user to input starting file path and path for output file.
 */
public class UserInputService implements InputService<String[]> {
    @Override
    public String[] getInput() {
        String[] result = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Input full path of the file, containing user -> emails");
        result[0] = sc.nextLine();
        System.out.println("Input full path to the file, where you want to see outputted result");
        result[1] = sc.nextLine();
        return result;
    }
}