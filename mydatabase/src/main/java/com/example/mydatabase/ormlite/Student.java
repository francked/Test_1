package com.example.mydatabase.ormlite;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by ryan on 18-8-28.
 */

public class Student {
    public static final String TABLE_NAME = "t_student";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;

    //学生所在的班级
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Class_1 class1;

    public Student(){

    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class_1 getClass1() {
        return class1;
    }

    public void setClass1(Class_1 class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
