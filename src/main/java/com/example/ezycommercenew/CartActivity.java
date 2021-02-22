package com.example.ezycommercenew;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezycommercenew.adapter.CartAdapter;
import com.example.ezycommercenew.bookmodel.CartProduct;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView recView;
    List<CartProduct> listCp;
    CartAdapter cartAdapter;
    public static TextView totalPrice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        totalPrice = findViewById(R.id.tvc_totalprice);
    }

}
