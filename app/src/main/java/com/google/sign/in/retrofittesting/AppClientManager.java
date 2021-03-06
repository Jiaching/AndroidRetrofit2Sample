package com.google.sign.in.retrofittesting;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClientManager {

    private static AppClientManager manager = new AppClientManager();
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private AppClientManager(){
        String URL = "https://jsonplaceholder.typicode.com/posts/";
        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public static Retrofit getClient(){
        return manager.retrofit;
    }

}
