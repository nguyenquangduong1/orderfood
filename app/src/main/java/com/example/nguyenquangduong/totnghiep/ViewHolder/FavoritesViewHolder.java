package com.example.nguyenquangduong.totnghiep.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nguyenquangduong.totnghiep.Interface.ItemClickListener;
import com.example.nguyenquangduong.totnghiep.R;

public class FavoritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView food_name, food_price;
    public ImageView food_image,fav_image,  quick_cart;

    public RelativeLayout view_backgroud;
    public LinearLayout view_foregroud;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private ItemClickListener itemClickListener;

    public FavoritesViewHolder(@NonNull View itemView) {
        super(itemView);

        food_price = (TextView)itemView.findViewById(R.id.food_price);

        food_name = (TextView)itemView.findViewById(R.id.food_name);
        food_image = (ImageView)itemView.findViewById(R.id.food_image);
        fav_image = (ImageView)itemView.findViewById(R.id.fav);
        quick_cart = (ImageView)itemView.findViewById(R.id.btn_quick_cart);

        view_backgroud = (RelativeLayout)itemView.findViewById(R.id.view_background);
        view_foregroud = (LinearLayout)itemView.findViewById(R.id.view_foreground);


        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
