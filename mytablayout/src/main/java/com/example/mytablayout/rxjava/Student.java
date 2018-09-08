package com.example.mytablayout.rxjava;

import java.util.List;

/**
 * Created by ryan on 18-8-21.
 */

public class Student {
    private String name;
    private int age;
    private List<Course> course;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
