package com.example.ezycommercenew;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezycommercenew.adapter.DetailAdapter;
import com.example.ezycommercenew.adapter.ProductAdapter;
import com.example.ezycommercenew.bookmodel.CartProduct;
import com.example.ezycommercenew.bookmodel.DetailProduct;
import com.example.ezycommercenew.bookmodel.ListProduct;
import com.example.ezycommercenew.retrofit.APIClient;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    RecyclerView recView;
    DetailAdapter deAdapt;
    List<CartProduct> cart;
    List<DetailProduct> listDp;
    DetailProduct detailProduct;

    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frgdetail_list);
        recView = findViewById(R.id.rvdetail);
        buy = findViewById(R.id.button_buy);
//        buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CartProduct cartProduct = new CartProduct();
//                cartProduct.setImage(detailProduct.getImg());
//                cartProduct.setName(detailProduct.getName());
//                cartProduct.setPrice(detailProduct.getPrice());
//                cartProduct.setQuantity(1);
//
//                cart.add(cartProduct);
//                Intent intent = new Intent(DetailActivity.this, CartActivity.class);
//                startActivity(intent);
//            }
//        });

        loadData();
    }

    private void loadData(){
        listDp = new ArrayList<>();
        deAdapt = new DetailAdapter(this, listDp);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(deAdapt);
        Call<ListProduct> callLP = APIClient.loadBook()
                .bookReq(getIntent().getExtras().getInt("bookId"),"2201791093","Andhika Naafi Ramadhan");

        callLP.enqueue(new Callback<ListProduct>() {
            @Override
            public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                ListProduct liPro = response.body();
                listDp.clear();
                listDp.addAll(liPro.getProducts());
                deAdapt.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListProduct> call, Throwable t) {

            }
        });
    }

    //3 jam pak saya disini
//    private void errorFix(List<DetailProduct> lDpr){
//        deAdapt = new DetailAdapter(this, lDpr);
//        recView.setLayoutManager(new LinearLayoutManager(this));
//        recView.setAdapter(deAdapt);
//    }

}
