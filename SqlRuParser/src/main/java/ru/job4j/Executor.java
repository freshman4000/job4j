package ru.job4j;

import java.util.Map;
import java.util.Set;

public interface Executor {
    void formFreshVacancies(Set<String> existing, Map<String, ParsableInfo> fresh);

    void execute();
}
