package com.google.sign.in.retrofittesting;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("/posts")
    Call<List<Posts>> index();
}