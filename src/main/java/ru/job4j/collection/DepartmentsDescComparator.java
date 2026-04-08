package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        int leftLength = left.split("/").length;
        int rightLength = right.split("/").length;
        int size = Math.min(leftLength, rightLength);

        for (int i = 0; i < size; i++) {
            String s1 = left.split("/")[i];
            String s2 = right.split("/")[i];
            if (i == 0) {
                result = s2.compareTo(s1);
            } else {
                result = s1.compareTo(s2);
            }
            if (result != 0) {
                break;
            }
        }

        if (result == 0 && leftLength != rightLength) {
            result = Integer.compare(leftLength, rightLength);
        }
        return result;
    }
}