package com.example.mydatabase.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ryan on 18-8-24.
    1 这里需要用 @Entity来注解该类
    2 至少要有一个主键 @PrimaryKey
 */


@Entity
public class User {

    //主键自增长，true
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int age;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
