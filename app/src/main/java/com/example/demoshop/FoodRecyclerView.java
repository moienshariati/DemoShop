package com.example.demoshop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodRecyclerView extends RecyclerView.Adapter<FoodRecyclerView.MyViewHolder> {
    private Context context;
    private List<Food> foodList = new ArrayList<>();

    public FoodRecyclerView(List<Food> foodList) {

        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food=foodList.get(position);
        holder.name.setText( food.getFoodNames());
        holder.description.setText(food.getDescription());
        holder.price.setText(Integer.toString(food.getFoodPrice()));

        byte[] foodimages=food.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(foodimages,0,foodimages.length);
        holder.thumbnail.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,description,price;
        public ImageView thumbnail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.description);
            price=itemView.findViewById(R.id.price);
            thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }


}
