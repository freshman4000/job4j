package ru.job4j.exam;

import java.util.*;

/**
 * Class Department that creates department and assigns code to it.
 */
public class Department {
    /**
     * Department set of codes.
     */
    private static Set<String> codes = new HashSet<>();

    private String code;

    public Department(String code) {
        this.code = code;
        codes.add(this.code);
    }

    public static Set<String> getCodes() {
        return codes;
    }

    /**
     * Sorts department codes in natural order.
     *
     * @return sorted list of codes.
     */
    public static List<String> sortNat() {
        List<String> depList = checkerForOccurrences(codes);
        System.out.println(depList);
        Collections.sort(depList);
        return depList;
    }

    /**
     * Sorts department codes in special reversed order.
     *
     * @return sorted list of codes.
     */
    public static List<String> sortRev() {
        List<String> result = checkerForOccurrences(codes);
        Comparator<String> cN = new Comparator<String>() {
            /**
             * First, comparing by head department number, then by depth of tree,
             * then by alphabetical order of chars in codes.
             * @param o1 previous code.
             * @param o2 next code.
             * @return comparison result.
             */
            @Override
            public int compare(String o1, String o2) {
                int result = o2.charAt(1) - (o1.charAt(1));
                return result == 0
                        ? o1.split("\\\\").length - o2.split("\\\\").length == 0
                        ? o2.compareTo(o1) : o1.split("\\\\").length - o2.split("\\\\").length : result;
            }
        };
        Collections.sort(result, cN);
        return result;
    }

    /**
     * Forms code list of created departments.
     *
     * @return list of formed codes.
     */
    public static List<String> formDepsCodeDataBase() {
        List<String> depCodes = new ArrayList<>();

        return depCodes;
    }

    /**
     * Method that checks if hierarchy of all departments is mirrored int the list, and if it is not -
     * restores it, by adding missing departments. For example, if subdepartment is
     * in the list, but its head(super) department - is not, then it adds head department to list.
     *
     * @param raw raw department list.
     * @return restored department list.
     */
    public static List<String> checkerForOccurrences(Set<String> raw) {
        List<String> transformer = new ArrayList<>(raw);
        ListIterator<String> le = transformer.listIterator();
        while (le.hasNext()) {
            String buff = "";
            for (String s : le.next().split("\\\\")) {
                buff = buff.equals("") ? buff.concat(s) : buff.concat("\\" + s);
                if (!transformer.contains(buff)) {
                    le.add(buff);
                }
            }
        }
        return transformer;
    }
}

