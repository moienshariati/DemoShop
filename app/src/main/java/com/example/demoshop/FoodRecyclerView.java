package com.example.demoshop;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
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


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class FoodRecyclerView extends RecyclerView.Adapter<FoodRecyclerView.MyViewHolder> {

    BottomNavigationView bottomNav;
    public TextView tvCardCounter;
    ConstraintLayout rootLayout;
    int counter = 0;



    private badgeListener listener;

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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.tvName.setText(food.getFoodNames());
        holder.tvDescription.setText(food.getDescription());
        holder.tvPrice.setText(Integer.toString(food.getFoodPrice()));

        byte[] foodimages = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodimages, 0, foodimages.length);
        holder.thumbnail.setImageBitmap(bitmap);


        // check if item still exists



//        holder.btnAddToCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(listener !=null){
//                    listener.onlistenerBadge(holder.btnAddToCard);
//                }
//            }
//        });

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
            bottomNav=itemView.findViewById(R.id.nav_card);


            btnAddToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    // get position
                    final  int position = getAdapterPosition();
                    // check if item still exists
                    if (position != RecyclerView.NO_POSITION) {
//                        counter = counter + 1;
                        if(listener !=null) {
                            listener.onlistenerBadge(btnAddToCard);
                        }


                        Thread thread=new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Food selectedFoodPosition = foodList.get(position);
                                FoodOrderingBussiness bussiness = new FoodOrderingBussiness(context);

                                int foodCounter=bussiness.addToBasket(selectedFoodPosition);

                                bottomNav.getOrCreateBadge(R.id.nav_card).setNumber(bussiness.getTotalCount());
                                if(foodCounter>=1){
                                    btnMinToCard.setVisibility(View.VISIBLE);
                                }else{
                                    btnMinToCard.setVisibility(View.INVISIBLE);

                                    Toast.makeText(v.getContext(), " تعداد کل = " + bussiness.getTotalCount() +
                                            " قیمت کل = " + bussiness.getTotalPrice(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                        thread.start();






//                        final Snackbar snackbar = Snackbar.make(rootFrameLayout, "تعداد کالا = " +bussiness.getTotalCount(), Snackbar.LENGTH_SHORT)
//
//                                .setAction("سبد خرید", new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        Intent intent = new Intent(context, FragmentHome.class);
//                                        context.startActivity(intent);
//
//
//                                    }
//                                });
//
//                        snackbar.show();


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

                        if (listener !=null){
                            listener.onListenerRemoveBadge(btnMinToCard);
                        }

//                        counter -= 1;
                        Thread thread=new Thread(new Runnable() {
                            @Override
                            public void run() {
                                FoodOrderingBussiness bussiness=new FoodOrderingBussiness(context);

                                int foodCounter = bussiness.removeItemFromBasket(foodList.get(position).getId());

                                if(foodCounter>=1){
                                    btnMinToCard.setVisibility(View.VISIBLE);
                                }else{
                                    btnMinToCard.setVisibility(View.INVISIBLE);
                                }
                            }
                        });
                        thread.start();


//                        if (removedCount == 0) {
//                            Toast.makeText(v.getContext(), "there is no item", Toast.LENGTH_SHORT).show();
//                        }else{
//
//                            Toast.makeText(v.getContext(), "succsessfully removed", Toast.LENGTH_SHORT).show();
//                        }

//                        final Snackbar snackbar = Snackbar.make(rootFrameLayout, "food counter = " + counter, Snackbar.LENGTH_SHORT)
//
//                                .setAction("CardShop", new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        Intent intent = new Intent(context,FragmentCard);
//                                        context.startActivity(intent);
//
//
//                                    }
//                                });
//
//                        snackbar.show();

                    }
                }


            });

        }
    }


    public interface badgeListener {
        void onlistenerBadge(View view);//func ke view migire v dar inja holder.btn ro gerefte

        void onListenerRemoveBadge(View view);//func ke view migire v dar inja holder.btn ro gerefte
    }

    public void onchangeBadge(badgeListener listener) {
        this.listener = listener;
        //func ke listener be badgelistener eshare mikone va mitonim har ja khastim estefade konim
    }

    //To OnBindViewHolder

    public void setData(List<Food> listFood){
        this.foodList=listFood;
        notifyDataSetChanged();
    }


}
