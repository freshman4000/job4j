package ru.job4j.srp.srpcalculator.launchers;

import ru.job4j.srp.srpcalculator.calculators.ICalculator;
import ru.job4j.srp.srpcalculator.inputs.InputKeyboard;
import ru.job4j.srp.srpcalculator.interfaces.*;
import ru.job4j.srp.srpcalculator.logics.ICLogic;
import ru.job4j.srp.srpcalculator.messageprinters.ICMessagePrinter;
import ru.job4j.srp.srpcalculator.messages.*;
import ru.job4j.srp.srpcalculator.processors.ICNumbersInputProcessor;
import ru.job4j.srp.srpcalculator.userinterfaces.InterCalcUI;
import ru.job4j.srp.srpcalculator.validators.ICCommandInputValidator;
import ru.job4j.srp.srpcalculator.validators.ICNumInputValidator;
import ru.job4j.srp.srpcalculator.validators.ValidationExecutor;

/**
 * This class is entrance point of program. It launches calculator.
 */
public class ICUILauncher implements Launcher<double[]> {
    private ValidationExecutor validationExecutor;
    @Override
    public void launch(UI ui,
                       Logic logic,
                       Input input,
                       MessagePrinter messagePrinter) {
        while (true) {
            ui.initUI();
            messagePrinter.printMessage(new CommandChoiceMessage());
            messagePrinter.printMessage(new SeparatorMessage());
            messagePrinter.printMessage(new MenuMessage());
            String command = input.passInput();
            //THIS IS MADE FOR TESTING PURPOSES ONLY
            if ("forcedExit".equals(command)) {
                break;
            }
            if (new ValidationExecutor<>(new ICCommandInputValidator(), command).executeVal()) {
                logic.executeLogic(command);
            } else {
                messagePrinter.printMessage(new NoSuchCommandMessage());
            }
        }
    }

    public static void main(String[] args) {
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new InputKeyboard()), new ICMessagePrinter(), new ICalculator()),
                new InputKeyboard(),
                new ICMessagePrinter()
        );
    }
}


