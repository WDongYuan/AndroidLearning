package com.example.lesson3_transmsgact;

import java.io.Serializable;

/**
 * Created by weidong on 28/12/2016.
 */

public class User implements Serializable{
    public String name;
    public String age;
    public User(String n, String a){
        name = n;
        age = a;
    }
}
