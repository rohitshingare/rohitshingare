package com.example.dell.dishservices.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.dishservices.Interface.ItemClickListener;
import com.example.dell.dishservices.R;

/**
 * Created by DELL on 14-04-2018.
 */

public class DishViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView dish_name;
    public ImageView dish_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DishViewHolder(View itemView) {
        super(itemView);
        dish_name=(TextView)itemView.findViewById(R.id.dish_name);
        dish_image=(ImageView) itemView.findViewById(R.id.dish_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}
