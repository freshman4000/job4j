package ru.job4j.isp.inputs;

public class BulkInput implements Input {
    private int position = 0;
    private String[] input;

    public BulkInput(String[] input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        String result = input[position++];
        return result;
    }
}
