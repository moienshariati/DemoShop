package com.example.demoshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasketRecyclerView extends RecyclerView.Adapter<BasketRecyclerView.MyBasketHolder> {
    private Context context;
    private List<Basket> basketList;

    public BasketRecyclerView(List<Basket> basketList, Context context) {
        this.basketList = basketList;
        this.context = context;
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
        TextView tvName, tvDescription, tvPrice,tvBasketCounter;

        public MyBasketHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_basket_name);
            tvDescription = itemView.findViewById(R.id.tv_basket_description);
            tvPrice = itemView.findViewById(R.id.tv_basket_price);
            tvBasketCounter = itemView.findViewById(R.id.tv_basket_counter);
        }
    }
}
