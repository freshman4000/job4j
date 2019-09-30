package ru.job4j.srp;

import java.lang.reflect.Method;
import java.util.List;

public interface CalcUI {
    List<Method> getActions();
    void initUIFields();
    void runUI(Calculator calculator);
    void invokeMethod(Calculator calculator, String methodName, double[] values);
}
