package com.example.sunmeter;

import android.media.Image;

public class User {
    String firstName;
    String age;
    String lastName; // this is profile image, i don't know why I change it to img it will return null;

    private User(String firstName,String age,String lastName){
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }
    public User(){}

    public String getFirstName() {
        return firstName;
    }



    public String getAge() {
        return age;
    }

    public String getLastName(){return lastName;}
}
