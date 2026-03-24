package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        // повышающие приведение:
        Freshman freshman = new Freshman();
        Student  student = freshman;
        Object object = student;
    }
}