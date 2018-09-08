package com.example.myhandler;

/**
 * Created by ryan on 18-9-7.
 */

public class C {
    public C(String s){
        System.out.println("B");
    }
    public static boolean returnText(){
        try {
            System.out.print("1");
            return true;
        }catch (Exception e){

        }finally {
            System.out.print("2");

            return false;
        }
    }

    public static void main(String[] args) {
        returnText();
    }



}
