package com.example.ezycommercenew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ezycommercenew.bookmodel.ListProduct;
import com.example.ezycommercenew.fragment.FragmentList;
import com.example.ezycommercenew.retrofit.APIClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        btn1 = findViewById(R.id.btn_accessories);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInit("accessories");
            }
        });

        btn2 = findViewById(R.id.btn_mystery);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInit("mystery");
            }
        });

        btn3 = findViewById(R.id.btn_business);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInit("business");
            }
        });

        btn4 = findViewById(R.id.btn_cookbooks);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInit("cookbooks");
            }
        });
        fragmentInit(null);
    }

    private void loadData(){
        Call<ListProduct> callLP = APIClient.loadBook().getAllBook("2201791093","Andhika Naafi Ramadhan");
        callLP.enqueue(new Callback<ListProduct>() {
            @Override
            public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                ListProduct liPro = response.body();
                Log.d("(result)", "onResponse: "+new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<ListProduct> call, Throwable t) {

            }
        });
    }

    private void fragmentInit(String category){
        Fragment fr = new FragmentList();
        FragmentManager frm = getSupportFragmentManager();
        FragmentTransaction frt = frm.beginTransaction();
        if(category != null){
            Bundle bundle = new Bundle();
            bundle.putString("category", category);
            fr.setArguments(bundle);
        }
        frt.replace(R.id.frame, fr);
        frt.commit();
    }

}