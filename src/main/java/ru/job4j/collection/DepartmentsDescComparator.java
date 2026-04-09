package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        String[] s1 = left.split("/");
        String[] s2 = right.split("/");

        int size = Math.min(s1.length, s2.length);
        for (int i = 0; i < size; i++) {
            result = i == 0 ? s2[i].compareTo(s1[i]) : s1[i].compareTo(s2[i]);
            if (result != 0) {
                break;
            }
        }

        return result != 0 ? result : left.compareTo(right);
    }
}