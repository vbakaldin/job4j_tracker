package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] s1 = left.split("/");
        String[] s2 = right.split("/");
        int result = s2[0].compareTo(s1[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}