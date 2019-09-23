package ru.job4j.vacancyparser;

import ru.job4j.Field;
import ru.job4j.ParsableInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlRuVacancy implements ParsableInfo {
    private List<Field> fields;

    public List<Field> getFields() {
        return fields;
    }

    @Override
    public void initFields(Field... args) {
        fields = new ArrayList<>();
        fields.addAll(Arrays.asList(args));
    }
}
