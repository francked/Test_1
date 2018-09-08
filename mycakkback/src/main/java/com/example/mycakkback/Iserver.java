package com.example.mycakkback;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 18-9-5.
 */

public class Iserver {

    private IA ia;


    public Iserver(IA ia) {
        this.ia = ia;
    }

    public void get(){
        ia.getid("回调");
    }
}
