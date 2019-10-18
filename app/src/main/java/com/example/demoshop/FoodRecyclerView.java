package com.example.demoshop;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class FoodRecyclerView extends RecyclerView.Adapter<FoodRecyclerView.MyViewHolder> {
    public TextView tvCardCounter;
    ConstraintLayout rootLayout;
    int counter = 0;
    int arcounter = 0;

    private Context context;
    private List<Food> foodList = new ArrayList<>();
    private List<Basket> basketList;


    public FoodRecyclerView(List<Food> foodList, ConstraintLayout rootLayout, Context context) {
        this.context = context;
        this.foodList = foodList;
        this.rootLayout = rootLayout;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.tvName.setText(food.getFoodNames());
        holder.tvDescription.setText(food.getDescription());
        holder.tvPrice.setText(Integer.toString(food.getFoodPrice()));


        byte[] foodimages = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodimages, 0, foodimages.length);
        holder.thumbnail.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button btnAddToCard, btnMinToCard;
        public TextView tvName, tvDescription, tvPrice;
        public ImageView thumbnail;
        public FrameLayout rootFrameLayout;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            rootLayout = itemView.findViewById(R.id.root_layout);
            tvName = itemView.findViewById(R.id.name);
            tvDescription = itemView.findViewById(R.id.description);
            tvPrice = itemView.findViewById(R.id.price);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            btnAddToCard = itemView.findViewById(R.id.btn_add_to_card);
            btnMinToCard = itemView.findViewById(R.id.btn_min_to_card);
            tvCardCounter = itemView.findViewById(R.id.tv_card_counter);
            rootFrameLayout = itemView.findViewById(R.id.root_frame);

            btnAddToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    final int position = getAdapterPosition();
                    // check if item still exists
                    if (position != RecyclerView.NO_POSITION) {
                        counter = counter + 1;


                        MyDataBase db = MyDataBase.getInstance(context);


                        Food selectedFood = foodList.get(position);
                        Basket foundRecord = db.getBasketDao().SelectById(selectedFood.getId());
                        if (foundRecord == null) {
                            Basket newItem = new Basket(selectedFood.getId(), selectedFood.getFoodNames(),
                                    selectedFood.getFoodPrice(), selectedFood.getDescription());

                            db.getBasketDao().InsertBasket(newItem);

                        } else {
                            foundRecord.foodCounter++;
                            db.getBasketDao().UpdateBasket(foundRecord);
                        }
                        Toast.makeText(v.getContext(), "Added db", Toast.LENGTH_SHORT).show();

//                        Basket basket1=new Basket(1,1,"ghaza",1,140);
//                        db.getBasketDao().InsertBasket(basket1);


                        final Snackbar snackbar = Snackbar.make(rootFrameLayout, "food counter = " + counter, Snackbar.LENGTH_INDEFINITE)

                                .setAction("CardShop", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(context, BasketActivity.class);
                                        context.startActivity(intent);


                                    }
                                });

                        snackbar.show();


//                        Toast.makeText(v.getContext(), "Cilciked " + position, Toast.LENGTH_SHORT).show();
                    }


                }
            });
            btnMinToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = getAdapterPosition();
                    // check if item still exists
                    if (position != RecyclerView.NO_POSITION) {

                        counter -= 1;
                        MyDataBase db = MyDataBase.getInstance(context);


                        Basket foundRecord = db.getBasketDao().SelectById(foodList.get(position).getId());
                       if(foundRecord == null)
                       {
                           Toast.makeText(v.getContext(), "there is no item", Toast.LENGTH_SHORT).show();
                       }
                        else if (foundRecord.foodCounter <= 1) {
                            db.getBasketDao().DeleteByID(foundRecord.id);
                        } else {
                            foundRecord.foodCounter--;
                            db.getBasketDao().UpdateBasket(foundRecord);
                        }
                        final Snackbar snackbar = Snackbar.make(rootFrameLayout, "food counter = " + counter, Snackbar.LENGTH_INDEFINITE)

                                .setAction("CardShop", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(context, BasketActivity.class);
                                        context.startActivity(intent);


                                    }
                                });

                        snackbar.show();

                    }
                }


            });

        }
    }


}
