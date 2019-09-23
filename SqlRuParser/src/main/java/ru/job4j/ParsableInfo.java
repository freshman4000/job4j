package ru.job4j;

import java.util.List;

public interface ParsableInfo {

    List<Field> getFields();

    void initFields(Field... args);

}
