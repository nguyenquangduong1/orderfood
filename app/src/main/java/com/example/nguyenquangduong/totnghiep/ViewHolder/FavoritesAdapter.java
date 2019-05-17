package com.example.nguyenquangduong.totnghiep.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nguyenquangduong.totnghiep.Common.Common;
import com.example.nguyenquangduong.totnghiep.Database.Database;
import com.example.nguyenquangduong.totnghiep.FoodDetail;
import com.example.nguyenquangduong.totnghiep.FoodList;
import com.example.nguyenquangduong.totnghiep.Interface.ItemClickListener;
import com.example.nguyenquangduong.totnghiep.Model.Favorites;
import com.example.nguyenquangduong.totnghiep.Model.Food;
import com.example.nguyenquangduong.totnghiep.Model.Order;
import com.example.nguyenquangduong.totnghiep.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesViewHolder> {

    private Context context;
    private List<Favorites> favoritesList;

    public FavoritesAdapter(Context context, List<Favorites> favoritesList) {
        this.context = context;
        this.favoritesList = favoritesList;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.favorites_item,viewGroup,false);
        return new FavoritesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder viewHolder, int position) {

        viewHolder.food_name.setText(favoritesList.get(position).getFoodName());
        viewHolder.food_price.setText(String.format("$ %s",favoritesList.get(position).getFoodPrice().toString()));
        Picasso.with(context).load(favoritesList.get(position).getFoodImage())
                .into(viewHolder.food_image);
        //Quick cart
        viewHolder.quick_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFoodExists = new Database(context).checkIfFoodExists(favoritesList.get(position).getFoodId(),Common.currentUser.getPhone());

                if(!isFoodExists) {
                new Database(context).addToCart(new Order(
                        Common.currentUser.getPhone(),
                        favoritesList.get(position).getFoodId(),
                        favoritesList.get(position).getFoodName(),
                        "1",
                        favoritesList.get(position).getFoodPrice(),
                        favoritesList.get(position).getFoodDiscount(),
                        favoritesList.get(position).getFoodImage()

                ));

                } else {

                    new Database(context).increaseCart(Common.currentUser.getPhone(),
                            favoritesList.get(position).getFoodId());
                }
                Toast.makeText(context, "Đã thêm vài giỏ hàng", Toast.LENGTH_SHORT).show();
            }
        });



        //click favorites

        final Favorites local = favoritesList.get(position);


        viewHolder.setItemClickListener(new ItemClickListener() {


            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent foodDetail = new Intent(context, FoodDetail.class);
                foodDetail.putExtra("foodId",favoritesList.get(position).getFoodId());
                context.startActivity(foodDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }
    public void removeItem(int position)
    {
        favoritesList.remove(position);
        notifyItemRemoved(position);
    }
    public void restoreItem(Favorites item,int position)
    {
        favoritesList.add(position,item);
        notifyItemInserted(position);

    }

    public Favorites getItem(int position)
    {
        return favoritesList.get (position);
    }
}
