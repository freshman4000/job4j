package ru.job4j.isp.inputs;

public class BulkInput implements Input {
    /**
     * Current position.
     */
    private int position = 0;
    /**
     * Input data.
     */
    private String[] input;

    public BulkInput(String[] input) {
        this.input = input;
    }

    /**
     * THis method gets and returns needed input.
     *
     * @return needed input.
     */
    @Override
    public String getInput() {
        return input[position++];
    }
}
