package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        boolean flag;
        for (int i = 2; i <= finish; i++) {
            flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            count = flag ? count + 1 : count;
        }
        return count;
    }
}

