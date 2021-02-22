package com.example.ezycommercenew.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ezycommercenew.CartActivity;
import com.example.ezycommercenew.DetailActivity;
import com.example.ezycommercenew.R;
import com.example.ezycommercenew.bookmodel.DetailProduct;
import com.example.ezycommercenew.bookmodel.ListProduct;

import java.util.ArrayList;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    private Context context;
    private List<DetailProduct> dp;



    public DetailAdapter(Context context, List<DetailProduct> dp) {
        this.context = context;
        this.dp = dp;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.templatedetail, parent, false);

        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        holder.tv_name.setText(dp.get(position).getName());
        holder.tv_author.setText(dp.get(position).getAuthor());
        holder.tv_price.setText("$" + dp.get(position).getPrice());
        holder.tv_type.setText(dp.get(position).getType());
        holder.tv_description.setText(dp.get(position).getDescription());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartActivity.class);
                intent.putExtra("bookId", dp.get(position).getId());
                context.startActivity(intent);
            }
        });

        Glide.with(context).load(dp.get(position).getImg()).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return dp.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_author, tv_price, tv_type, tv_description;
        ImageView img;
        Button btn;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tvd_name);
            tv_author = itemView.findViewById(R.id.tvd_author);
            tv_price = itemView.findViewById(R.id.tvd_price);
            tv_type = itemView.findViewById(R.id.tvd_type);
            tv_description = itemView.findViewById(R.id.tvd_description);
            img = itemView.findViewById(R.id.imageView);
            btn = itemView.findViewById(R.id.button_buy);
        }
    }

    }

