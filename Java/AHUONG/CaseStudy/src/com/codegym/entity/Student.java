package com.codegym.entity;

import java.util.Arrays;

public class Student implements Comparable<Student>{
    private String studentCode;
    private String name;
    private String gender;
    private String dob;
    private String className;
    private double[] mark = {0,0,0,0};
    private double averageMark = 0;
    private String grade = "";

    public Student() {
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getClassName() {
        return className;
    }

    public double[] getMark() {
        return mark;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public String getGrade() {
        return grade;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMark(double[] mark) {
        this.mark = mark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        if (o.getAverageMark() == this.getAverageMark()) {
            return 0;
        } if (o.getAverageMark() > this.getAverageMark()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return
                "StudentCode: " + studentCode +
                ", Name: " + name +
                ", Gender: " + gender +
                ", DOB: " + dob +
                ", Class: " + className +
                ", Marks: " + Arrays.toString(mark) +
                ", Average Mark: " + averageMark +
                ", Grade: " + grade + ".";
    }
}
