package com.example.ezycommercenew.retrofit;

import com.example.ezycommercenew.bookmodel.DetailProduct;
import com.example.ezycommercenew.bookmodel.ListProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIEndPoint {
    @GET("staging/book")
    Call<ListProduct> getAllBook(@Query("nim") String nim, @Query("nama") String nama);

    @GET("/staging/book/{bookId}")
    Call<ListProduct> bookReq(@Path("bookId") Integer idBooks, @Query("nim") String nim, @Query("nama") String nama);
}
