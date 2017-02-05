package com.droiddigger.retrofitexample.api_interface;


import com.droiddigger.retrofitexample.model.Customer;
import com.droiddigger.retrofitexample.model.ServerResponse;
import com.droiddigger.retrofitexample.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInteface {

    @POST("/test/registration.php")
    Call<ServerResponse>getRegistrationToken(@Body User user);

    @POST("/test/user.php")
    Call<ServerResponse>getUserName(@Body Customer customer);
    
    @POST("test/add_post.php")
    Call<ServerResponse>addPost(@Body Post pos);
    
    @GET("test/post.php")
    Call<ServerResponse>retrievePosts();
}
