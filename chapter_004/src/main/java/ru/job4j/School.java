package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public static Map<String, Student> formMap(List<Student> students) {
        Set<Student> set = new TreeSet<>(students);
        return set.stream()
                .collect(Collectors.toMap(Student::getLastName, student -> student));
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .filter(x -> x.getScore() > bound)
                .collect(Collectors.toList());
    }

}
