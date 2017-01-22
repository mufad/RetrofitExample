package com.droiddigger.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mufad on 1/22/2017.
 */

public class User {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("password")
    private String password;

    public User(){}

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
