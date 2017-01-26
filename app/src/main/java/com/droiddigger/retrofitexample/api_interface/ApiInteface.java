package com.droiddigger.retrofitexample.api_interface;


import com.droiddigger.retrofitexample.model.ServerResponse;
import com.droiddigger.retrofitexample.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInteface {
    @POST("/test/server_side_code.php")
    Call<ServerResponse> getUserValidity(@Body User userLoginCredential);

    @GET("/test/server_side_code.php")
    Call<ServerResponse> getJoke(@Query("user_id") String userId);

    @POST("/test/registration.php")
    Call<ServerResponse>getRegistrationToken(@Body User user);
}
