package ru.job4j.srp.srpcalculator.interfaces;

public interface Launcher<T> {
    void launch(UI ui,
                Logic logic,
                Input input,
                MessagePrinter messagePrinter
    );
}
