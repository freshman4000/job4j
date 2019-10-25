package ru.job4j.services.inputservices;

/**
 * Class, that evaluates input from parameters, mentioned at App starting point.
 */
public class ArgsInputService implements InputService<String[]> {
    private String[] args;

    public ArgsInputService(String[] args) {
        this.args = args;
    }

    @Override
    public String[] getInput() {
        return args;
    }
}
