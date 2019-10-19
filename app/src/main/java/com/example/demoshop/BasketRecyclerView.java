package com.example.demoshop;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasketRecyclerView extends RecyclerView.Adapter<BasketRecyclerView.MyBasketHolder> {
    private Context context;
    private List<Basket> basketList;
    private List<Food> foodList;

    public BasketRecyclerView(List<Basket> basketList, Context context, List<Food> foodList) {
        this.basketList = basketList;
        this.context = context;
        this.foodList = foodList;


    }

    @NonNull
    @Override

    // inflate card list
    public MyBasketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_basket, parent, false);
        return new MyBasketHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyBasketHolder holder, int position) {
//        MyDataBase db = MyDataBase.getInstance(context);
//        basketList=db.getBasketDao().SelectAllBaskets();
        Basket basket = basketList.get(position);

        holder.tvName.setText(basket.getFoodName());
        holder.tvDescription.setText(basket.getDescription());
        holder.tvPrice.setText(Integer.toString(basket.getPrice()));
        holder.tvBasketCounter.setText(Integer.toString(basket.getFoodCounter()));

    }

    @Override
    public int getItemCount() {
        return basketList.size();
    }

    public class MyBasketHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription, tvPrice, tvBasketCounter;
        Button btnIncrease, btnDecrease;

        public MyBasketHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_basket_name);
            tvDescription = itemView.findViewById(R.id.tv_basket_description);
            tvPrice = itemView.findViewById(R.id.tv_basket_price);
            tvBasketCounter = itemView.findViewById(R.id.tv_basket_counter);
            btnIncrease = itemView.findViewById(R.id.btn_add_to_cardbasket);
            btnDecrease = itemView.findViewById(R.id.btn_min_to_cardbasket);


            btnIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    final int position = getAdapterPosition();
                    // check if item still exists
                    if (position != RecyclerView.NO_POSITION) {
                        Food foodSelected = foodList.get(position);
                        Basket basketSelected = basketList.get(position);

                        FoodOrderingBussiness bussiness = new FoodOrderingBussiness(context);

                        bussiness.addToBasket(foodSelected);
//                        db.getBasketDao().SelectById(selectedFood.getId());
                        MyDataBase db = MyDataBase.getInstance(context);
                        basketList = db.getBasketDao().SelectAllBaskets();
                        setData(basketList);
                    }


                }
            });

            btnDecrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {

                        FoodOrderingBussiness bussiness = new FoodOrderingBussiness(context);

                        int removedCount=bussiness.removeItemFromBasket(basketList.get(position).getId());
                        MyDataBase db = MyDataBase.getInstance(context);
                        basketList = db.getBasketDao().SelectAllBaskets();
                        setData(basketList);

                        if (removedCount == 0){
                            Toast.makeText(v.getContext(), "There is No Item", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(v.getContext(), "Removed", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            });

        }
    }

    public interface OnQuantityChangeListener {
        void onQuantityChange(float change);
    }

    public void setData(List<Basket> basketData) {
        this.basketList = basketData;
        notifyDataSetChanged();
    }

}
