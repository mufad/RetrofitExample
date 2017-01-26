package com.droiddigger.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mufad on 1/22/2017.
 */

public class User {
    @SerializedName("name")
    private String name;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;

    public User(){}

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
