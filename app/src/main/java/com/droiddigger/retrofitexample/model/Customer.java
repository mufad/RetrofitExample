package com.droiddigger.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mufad on 1/26/2017.
 */

public class Customer {

    @SerializedName("email")
    private String name;
    @SerializedName("password")
    private String password;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
