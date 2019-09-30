package ru.job4j.srp.interactcalc;

import ru.job4j.srp.CalcUI;
import ru.job4j.srp.Calculator;
import ru.job4j.srp.ValInput;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class responsible for user communication.
 */
public class InteractCalcUI implements CalcUI {
    /**
     * Current methods list, that exist in current CALCULATOR class.
     */
    private LinkedList<Method> actions = new LinkedList<>();
    /**
     * Current validation class, responsible for VALIDATION of input arguments.
     */
    private ValInput valInput;

    /**
     * Current class constructor.
     */
    public InteractCalcUI() {
        initUIFields();
        valInput = new InteractCalcValInput();
    }

    /**
     * Getter for "actions" variable.
     * @return "actions" variable value.
     */
    public LinkedList<Method> getActions() {
        return actions;
    }

    /**
     * This methods fills "actions" variable with user defined methods from specified CALCULATOR class.
     * It picks only those mathematical function methods.
     */
    @Override
    public void initUIFields() {
        Method[] methods = InteractCalc.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (!methods[i].getName().contains("lambda")) {
                actions.add(methods[i]);
            }
        }
    }

    /**
     * This method runs communication process and reacts on different user input values using validation values
     * from appropriate ValInput class implementation.
     * @param calculator current Calculator class specified.
     */
    @Override
    public void runUI(Calculator calculator) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose action or type \"exit\" to leave:");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(String.format(("%d. %s"), i, actions.get(i).getName()));
            }
            String choice = sc.nextLine();
            if (choice.equals("exit")) {
                break;
            } else {
                if (valInput.valAction(this, choice)) {
                    int methodId = Integer.parseInt(choice);
                    String methodName = actions.get(methodId).getName();
                    if (!valInput.valMethodName(methodName)) {
                        System.out.println("PLease input values, separated by SINGLE whitespace");
                        String input = sc.nextLine();
                        if (valInput.valValues(input)) {
                            double[] values = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).toArray();
                                invokeMethod(calculator, methodName, values);
                        } else {
                            System.out.println("Wrong input. Check if values are numbers, separated by single whitespace and using \"dot\" as floating point separator");
                        }
                    } else {
                        invokeMethod(calculator, methodName);
                    }
                } else {
                    System.out.println("Action is not in range");
                }
            }
        }
    }

    /**
     * This method invokes method from Calculator class depending on what value was passed by user.
     * @param calculator current Calculator class.
     * @param methodName name of method picked by user.
     * @param values values passed by user.
     */
    @Override
    public void invokeMethod(Calculator calculator, String methodName, double[] values) {
        try {
            Method chosenMethod = InteractCalc.class.getMethod(methodName, double[].class);
            try {
                System.out.println(chosenMethod.invoke(calculator, (Object) values));
            } catch (InvocationTargetException e) {
                System.out.println("Can't perform action! Do correct input, plz");
            }
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * This overloaded method invokes instance method which doesn't need input parameters.
     * In this particular case - it is "clear" method.
     *
     * @param calculator current Calculator class.
     * @param methodName name of specified method.
     */
    public void invokeMethod(Calculator calculator, String methodName) {

        Method chosenMethod = null;
        try {
            chosenMethod = InteractCalc.class.getMethod(methodName);
            chosenMethod.invoke(calculator);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new InteractCalcUI().runUI(new InteractCalc());
    }
}
