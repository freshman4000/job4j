package ru.job4j.srp.srpcalculator.logics;

import ru.job4j.srp.srpcalculator.interfaces.Logic;
import ru.job4j.srp.srpcalculator.calculators.ICalculator;
import ru.job4j.srp.srpcalculator.commands.*;
import ru.job4j.srp.srpcalculator.logs.State;
import ru.job4j.srp.srpcalculator.messageprinters.ICMessagePrinter;
import ru.job4j.srp.srpcalculator.messages.ErrorMessage;
import ru.job4j.srp.srpcalculator.messages.SuggestInputNumMessage;
import ru.job4j.srp.srpcalculator.messages.SuggestInputOnlyMultipleNumMessage;
import ru.job4j.srp.srpcalculator.processors.ICNumbersInputProcessor;
import ru.job4j.srp.srpcalculator.validators.ICTwoOrMoreInputNumValidator;

/**
 * This class is responsible for logic of every command.
 */
public class ICLogic implements Logic {
    private ICTwoOrMoreInputNumValidator validator;
    private ICNumbersInputProcessor processor;
    private ICMessagePrinter messagePrinter;
    private ICalculator calculator;

    public ICLogic(ICNumbersInputProcessor processor, ICMessagePrinter messagePrinter, ICalculator calculator) {
        this.processor = processor;
        this.messagePrinter = messagePrinter;
        this.calculator = calculator;
        this.validator = new ICTwoOrMoreInputNumValidator();
    }

    @Override
    public void executeLogic(String input) {
        boolean on = State.isReuseOn();
        switch (input) {
            case "0":
                calculator.doAction(new ClearCommand());
                break;
            case "1":
                messagePrinter.printMessage(new SuggestInputNumMessage());
                try {
                    double[] numbersInput = processor.process();
                    calculator.doAction(new AddCommand(numbersInput));
                } catch (IllegalArgumentException e) {
                    messagePrinter.printMessage(new ErrorMessage());
                }
                break;
            case "2":
                messagePrinter.printMessage(new SuggestInputNumMessage());
                try {
                    double[] numbersInput = processor.process();
                    calculator.doAction(new SubtractCommand(numbersInput));
                } catch (IllegalArgumentException e) {
                    messagePrinter.printMessage(new ErrorMessage());
                }
                break;
            case "3":
                if (!on) {
                    messagePrinter.printMessage(new SuggestInputNumMessage());
                } else {
                    messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                }
                try {
                    double[] numbersInput = processor.process();
                    if (!on && !validator.validate(numbersInput)) {
                        messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                    } else {
                        calculator.doAction(new MultiplyCommand(numbersInput));
                    }
                } catch (IllegalArgumentException e) {
                    messagePrinter.printMessage(new ErrorMessage());
                }
                break;
            case "4":
                if (!on) {
                    messagePrinter.printMessage(new SuggestInputNumMessage());
                } else {
                    messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                }
                try {
                    double[] numbersInput = processor.process();
                    if (!on && !validator.validate(numbersInput)) {
                        messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                    } else {
                        calculator.doAction(new DivideCommand(numbersInput));
                    }
                } catch (IllegalArgumentException e) {
                    messagePrinter.printMessage(new ErrorMessage());
                }
                break;
            case "5":
                calculator.doAction(new ExitCommand());
            default : break;
        }
    }
}
