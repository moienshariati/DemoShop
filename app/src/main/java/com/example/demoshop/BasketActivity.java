package com.example.demoshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class BasketActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BasketRecyclerView adapter;
    List<Basket> baskets;
    TextView tvtotalpricebasket;

    ImageView ivDeleteQuery;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        recyclerView = findViewById(R.id.rv_basket);
        ivDeleteQuery=findViewById(R.id.iv_delete_query);
        tvtotalpricebasket=findViewById(R.id.tv_total_price_basket);


        recyclerView.setLayoutManager(new LinearLayoutManager(BasketActivity.this));
        final MyDataBase db = MyDataBase.getInstance(BasketActivity.this);

        baskets = db.getBasketDao().SelectAllBaskets();

        List<Food> foods = db.getFoodDao().SelectAllFoods();

        adapter = new BasketRecyclerView(baskets, BasketActivity.this,foods);
        recyclerView.setAdapter(adapter);

        tvtotalpricebasket.setText(Integer.toString(db.getBasketDao().getTotalPrice()));
        ivDeleteQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(BasketActivity.this)
                        .setTitle("Are You Sure?")
                        .setMessage("it's going to delete all your list")
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        db.getBasketDao().deletListBasket(baskets);
                                        baskets=db.getBasketDao().SelectAllBaskets();
                                        adapter.setData(baskets);
                                    }
                                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();


            }
        });





    }


}
