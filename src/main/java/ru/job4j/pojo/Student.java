package ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String fullName;
    private String group;
    private LocalDate admissionDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(int year, int month, int dayOfMonth) {
        this.admissionDate = LocalDate.of(year, month, dayOfMonth);
    }
}
