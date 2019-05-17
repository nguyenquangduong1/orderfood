package com.example.nguyenquangduong.totnghiep.ViewHolder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nguyenquangduong.totnghiep.Home;
import com.example.nguyenquangduong.totnghiep.Interface.ItemClickListener;
import com.example.nguyenquangduong.totnghiep.MainActivity;
import com.example.nguyenquangduong.totnghiep.OrderStatus;
import com.example.nguyenquangduong.totnghiep.R;

public class OrderViewHolder extends RecyclerView.ViewHolder  {
    public TextView txtOrderId, txtOrderStatus, txtOrderPhone, txtOrderAddress;
    private ItemClickListener itemClickListener;


    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderAddress = (TextView)itemView.findViewById(R.id.order_address);
        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        txtOrderPhone = (TextView)itemView.findViewById(R.id.order_phone);

      //  itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

//    @Override
//    public void onClick(View view) {
//        itemClickListener.onClick(view,getAdapterPosition(),false);
//
//
//    }
}
