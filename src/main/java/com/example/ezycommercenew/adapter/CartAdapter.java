package com.example.ezycommercenew.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ezycommercenew.R;
import com.example.ezycommercenew.bookmodel.CartProduct;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<CartProduct> listCart;

    public CartAdapter(Context context, List<CartProduct> listCart) {
        this.context = context;
        this.listCart = listCart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.templatecart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProduct cart = listCart.get(position);
        holder.name.setText(cart.getName());
        holder.price.setText(String.valueOf(cart.getPrice()));
        holder.quantity.setText(cart.getQuantity());
        Glide.with(context).load(cart.getImage()).into(holder.img);
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listCart.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name, price, quantity;
        private Button minus, plus;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewCart);
            name = itemView.findViewById(R.id.tvc_name);
            price = itemView.findViewById(R.id.tvc_price);
            quantity = itemView.findViewById(R.id.tvc_quantity);
            minus = itemView.findViewById(R.id.btn_minus);
            plus = itemView.findViewById(R.id.btn_plus);
        }
    }
}
