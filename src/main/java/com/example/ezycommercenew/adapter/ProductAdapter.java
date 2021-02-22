package com.example.ezycommercenew.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ezycommercenew.DetailActivity;
import com.example.ezycommercenew.R;
import com.example.ezycommercenew.bookmodel.DetailProduct;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<DetailProduct> dp;

    public void setDp(List<DetailProduct> dp) {
        this.dp = dp;
    }

    public ProductAdapter(Context context, List<DetailProduct> dp) {
        this.context = context;
        this.dp = dp;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.templatelist, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.name.setText(dp.get(position).getName());
        holder.author.setText(dp.get(position).getAuthor());
        holder.price.setText("$" + dp.get(position).getPrice());
        holder.llDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("bookId", dp.get(position).getId());
                context.startActivity(intent);
            }
        });

        Glide.with(context)
                .load(dp.get(position).getImg())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dp.size();
    }



    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView name,author,price;
        ImageView image;
        ConstraintLayout llDetail;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            author = itemView.findViewById(R.id.tv_author);
            price = itemView.findViewById(R.id.tv_price);
            image = itemView.findViewById(R.id.imgview);
            llDetail = itemView.findViewById(R.id.booklayout);
        }
    }

}
