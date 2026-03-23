package ru.job4j.oop;

public class Max {
    public static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int findMax(int a, int b, int c) {
        return findMax(a, findMax(b, c));
    }

    public static int findMax(int a, int b, int c, int d) {
        return findMax(a, findMax(b, findMax(c, d)));
    }
}