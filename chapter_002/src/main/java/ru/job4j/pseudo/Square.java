package ru.job4j.pseudo;

public class Square implements Shape{
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n\r");
        pic.append("+  +\n\r");
        pic.append("+  +\n\r");
        pic.append("++++\n\r");
        return pic.toString();
    }
}
