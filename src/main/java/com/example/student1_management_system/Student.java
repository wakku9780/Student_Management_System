package com.example.student1_management_system;

public class Student {
    private int rollNo;
    private String name;
    private int age;
    private String mobNo;

    public String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student(int rollNo, String name, int age, String mobNo, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.mobNo =mobNo;
        this.grade=grade;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
