package ru.job4j.oop;

public class Max {
    public static int findMax(int a, int b, int c) {
        return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
    }

    public static int findMax(int a, int b, int c, int d) {
        return (a > b ? a : b) > (c > d ? c : d) ? (a > b ? a : b) : (c > d ? c : d);
    }
}
