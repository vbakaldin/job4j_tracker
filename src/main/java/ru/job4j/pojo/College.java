package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Бакалдин Владимир");
        student.setGroup("Стажер");
        student.setAdmissionDate(2026, 3, 1);

        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getAdmissionDate());
    }
}
