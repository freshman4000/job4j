package ru.job4j.srp.srpcalculator.logics;

import ru.job4j.srp.srpcalculator.interfaces.Logic;
import ru.job4j.srp.srpcalculator.calculators.ICalculator;
import ru.job4j.srp.srpcalculator.commands.*;
import ru.job4j.srp.srpcalculator.logs.State;
import ru.job4j.srp.srpcalculator.messageprinters.ICMessagePrinter;
import ru.job4j.srp.srpcalculator.messages.*;
import ru.job4j.srp.srpcalculator.processors.ICNumbersInputProcessor;
import ru.job4j.srp.srpcalculator.validators.ICOneNumValidator;
import ru.job4j.srp.srpcalculator.validators.ICTwoNumValidator;
import ru.job4j.srp.srpcalculator.validators.ICTwoOrMoreInputNumValidator;
import ru.job4j.srp.srpcalculator.validators.ValidationExecutor;

/**
 * This class is responsible for logic of every command.
 */
public class ICLogic implements Logic {
    private ValidationExecutor validationExecutor;
    private ICNumbersInputProcessor processor;
    private ICMessagePrinter messagePrinter;
    private ICalculator calculator;

    public ICLogic(ICNumbersInputProcessor processor, ICMessagePrinter messagePrinter, ICalculator calculator) {
        this.processor = processor;
        this.messagePrinter = messagePrinter;
        this.calculator = calculator;
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
                    messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                } else {
                    messagePrinter.printMessage(new SuggestInputNumMessage());
                }
                try {
                    double[] numbersInput = processor.process();
                    if (!on && !new ValidationExecutor<>(new ICTwoOrMoreInputNumValidator(), numbersInput).executeVal()) {
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
                    messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                } else {
                    messagePrinter.printMessage(new SuggestInputNumMessage());
                }
                try {
                    double[] numbersInput = processor.process();
                    if (!on && !new ValidationExecutor<>(new ICTwoOrMoreInputNumValidator(), numbersInput).executeVal()) {
                        messagePrinter.printMessage(new SuggestInputOnlyMultipleNumMessage());
                    } else {
                        calculator.doAction(new DivideCommand(numbersInput));
                    }
                } catch (IllegalArgumentException e) {
                    messagePrinter.printMessage(new ErrorMessage());
                }
                break;
            case "6":
                messagePrinter.printMessage(new OneNumberAppealMessage());
                double[] numbersInput = processor.process();
                if (new ValidationExecutor<>(new ICOneNumValidator(), numbersInput).executeVal()) {
                    calculator.doAction(new SineCommand(numbersInput));
                } else {
                    messagePrinter.printMessage(new WrongInputMessage());
                }
                break;
            case "7":
                messagePrinter.printMessage(new OneNumberAppealMessage());
                double[] numbersInput1 = processor.process();
                if (new ValidationExecutor<>(new ICOneNumValidator(), numbersInput1).executeVal()) {
                    calculator.doAction(new CosCommand(numbersInput1));
                } else {
                    messagePrinter.printMessage(new WrongInputMessage());
                }
                break;
            case "8":
                if (on) {
                    messagePrinter.printMessage(new OneNumberAppealMessage());
                } else {
                    messagePrinter.printMessage(new TwoNumAppealMessage());
                }
                double[] numbersInput2 = processor.process();
                if (new ValidationExecutor<>(new ICTwoNumValidator(), numbersInput2).executeVal()) {
                    calculator.doAction(new PowerCommand(numbersInput2));
                } else {
                    messagePrinter.printMessage(new WrongInputMessage());
                }
                break;
            case "9":
                messagePrinter.printMessage(new OneNumberAppealMessage());
                double[] numbersInput3 = processor.process();
                if (new ValidationExecutor<>(new ICOneNumValidator(), numbersInput3).executeVal()) {
                    calculator.doAction(new LogCommand(numbersInput3));
                } else {
                    messagePrinter.printMessage(new WrongInputMessage());
                }
                break;
            case "5":
                calculator.doAction(new ExitCommand());
            default:
                break;
        }
    }
}
