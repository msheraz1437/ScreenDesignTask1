package com.example.screendesigntask1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final Context context;
    private List<ProductData> productData;

    public ProductAdapter(List<ProductData> productData, Context context) {
        this.productData = productData;
        this.context = context;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_view, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.name.setText(productData.get(position).getProductName());
        viewHolder.price.setText("₹"+productData.get(position).getPrice());
        viewHolder.imgViewIcon.setImageResource(productData.get(position).getImagesUrl());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ProductDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data",productData.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,price;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            name = (TextView) itemLayoutView.findViewById(R.id.name);
            price = (TextView) itemLayoutView.findViewById(R.id.price);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.image);
        }
    }


    @Override
    public int getItemCount() {
        return productData.size();
    }
}