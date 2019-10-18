package com.example.demoshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.List;

public class BasketActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BasketRecyclerView adapter;
    List<Basket> baskets;
    Basket basketkh;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        recyclerView = findViewById(R.id.rv_basket);

        recyclerView.setLayoutManager(new LinearLayoutManager(BasketActivity.this));

        MyDataBase db = MyDataBase.getInstance(BasketActivity.this);


        baskets = db.getBasketDao().SelectAllBaskets();

//        int id1 = 1;
//
//        if (baskets == null) {
//            baskets = db.getBasketDao().SelectAllBaskets();
//        }
//            else{
//                baskets = (List<Basket>) db.getBasketDao().SelectFoodCounter();
//
//
//        }


        adapter = new BasketRecyclerView(baskets, BasketActivity.this);
        recyclerView.setAdapter(adapter);


    }
}
