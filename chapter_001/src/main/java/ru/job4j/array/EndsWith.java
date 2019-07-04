package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class EndsWith {

    /**
     * Проверяет. что слово ends with префикс.
     * @param post префикс.
     * @return если слово ends with префикс.
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        for (int i = 0; i < pst.length; i++) {
            if (pst[pst.length - 1 - i] != wrd[wrd.length - 1 - i]) {
                result = false;
            }
        }
        return result;
    }
}
