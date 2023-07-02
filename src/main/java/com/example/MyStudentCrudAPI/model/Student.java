package com.example.MyStudentCrudAPI.model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private int roll;

    private String name;

    private String dept;

    private float marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", roll='" + roll + '\'' + ", name='" + name + '\'' +
                ", dept='" + dept + '\'' + ", marks='" + marks + '\'' + '}';
    }
}
