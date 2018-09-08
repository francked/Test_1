package com.example.mymvp.login.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ryan on 18-8-29.
 */

@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;

    private String name;

    private String pass;

    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 615523304)
    public User(Long id, String name, String pass, int age) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }




}
