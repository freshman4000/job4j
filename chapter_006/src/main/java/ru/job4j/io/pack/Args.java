package ru.job4j.io.pack;

public class Args {
    String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String directory() {
        return this.args[1];
    }

    public String exclude() {
        return this.args[3];
    }

    public String output() {
        return this.args[5];
    }
}
