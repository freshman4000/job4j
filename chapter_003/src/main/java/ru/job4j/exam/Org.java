package ru.job4j.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Org {
    private static  List<Dept> list;

    public List<Dept> getListOfDept() {
        return list;
    }

    public void setList(List<Dept> list) {
        Org.list = list;
    }

    Comparator<Dept> nat = new Comparator<Dept>() {
        @Override
        public int compare(Dept o1, Dept o2) {
            return o1.code.compareTo(o2.code);
        }
    };
    Comparator<Dept> rev = new Comparator<Dept>() {
        @Override
        public int compare(Dept o1, Dept o2) {
            int numOfDep = o2.code.charAt(1) - o1.code.charAt(1);
            int length = o1.code.length() - o2.code.length();
            return numOfDep == 0 ? length == 0 ? o2.code.compareTo(o1.code) : length : numOfDep;
        }
    };

    static class Dept {
        String code;

        public Dept(String code) {
            this.code = code;
        }
    }
}
