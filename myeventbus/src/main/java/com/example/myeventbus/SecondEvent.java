package com.example.myeventbus;

/**
 * Created by ryan on 18-9-5.
 */

public class SecondEvent {

    private String name;

    public SecondEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
