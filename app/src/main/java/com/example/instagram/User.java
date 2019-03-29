package com.example.instagram;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("User")
public class User extends ParseObject {
    public static final String Key_Email = "email";
    public static final String Key_Password = "password";
    public static final String Key_User = "user";

    public String getEmail(){
        return getString(Key_Email);
    }

    public void setEmail(String email){
        put(Key_Email, email);

    }
    public String getPassword(){
        return getString(Key_Password);
    }

    public void setPassword(String Password){
        put(Key_Password, Password);
    }

    public String getUser(){
        return getString(Key_User);
    }

    public void setUser(String user){
        put(Key_User, user);
    }
}
