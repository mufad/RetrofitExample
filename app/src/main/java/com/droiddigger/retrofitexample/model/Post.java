package com.droiddigger.retrofitexample.model;

import com.google.gson.annotations.SerializedName;


public class Post{
    @SerializedName("name")
    private String name;
    @SerializedName("post")
    private String post;
  
  public Post(String name, String post){
    this.name=name;
    this.post=post;
  }
}
