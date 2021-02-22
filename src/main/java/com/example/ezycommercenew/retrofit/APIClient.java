package com.example.ezycommercenew.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://u73olh7vwg.execute-api.ap-northeast-2.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static APIEndPoint loadBook(){
        APIEndPoint ep = retrofit.create(APIEndPoint.class);
        return ep;
    }
}
