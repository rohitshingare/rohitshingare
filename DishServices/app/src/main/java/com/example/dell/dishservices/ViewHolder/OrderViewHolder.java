package com.example.dell.dishservices.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dell.dishservices.Interface.ItemClickListener;
import com.example.dell.dishservices.R;

/**
 * Created by DELL on 24-04-2018.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtOrderStatus,txtOrderPhone,txtOrderAdress,txtOrderId;

    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);
        txtOrderAdress = (TextView)itemView.findViewById(R.id.order_adress);
        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);
        txtOrderPhone = (TextView)itemView.findViewById(R.id.order_phone);
        txtOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
