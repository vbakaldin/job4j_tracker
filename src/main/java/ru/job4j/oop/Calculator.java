package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divine(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divine(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        result = Calculator.minus(10);
        System.out.println(result);

        Calculator calculator = new Calculator();
        result = calculator.multiply(10);
        System.out.println(result);
        result = calculator.divine(10);
        System.out.println(result);
        result = calculator.sumAllOperation(10);
        System.out.println(result);
    }
}