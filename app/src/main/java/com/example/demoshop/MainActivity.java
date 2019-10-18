package com.example.demoshop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout rootLayout;
    public int count = 0;
    public Toolbar toolbar;
    Food food1, food2, food3, food4, food5, food6, food7, food8;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.root_layout);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        MyDataBase db = MyDataBase.getInstance(MainActivity.this);

        addStaticData();

        db.getFoodDao().InsertFoods(food1, food2, food3, food4, food5, food6, food7, food8);


        List<Food> foods = db.getFoodDao().SelectAllFoods();

        RecyclerView recyclerView;
        FoodRecyclerView adapter;

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FoodRecyclerView(foods, rootLayout, MainActivity.this);
        recyclerView.setAdapter(adapter);


//        String info = "";
//
//
//        for (Food food : foods) {
//            int id = food.getId();
//            String tvName = food.getFoodNames();
//            String tvDescription = food.getDescription();
//
//
//            info = info + "\n\n+" + ":id " + id + "\n\n" + tvName + "\n\n" + "tvDescription" + "\n\n" + tvDescription;

    }

    // add static data
    public void addStaticData() {
        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_food1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_food2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.ic_food3);
        Drawable drawable4 = getResources().getDrawable(R.drawable.ic_food4);
        Drawable drawable5 = getResources().getDrawable(R.drawable.ic_food5);
        Drawable drawable6 = getResources().getDrawable(R.drawable.ic_food6);
        Drawable drawable7 = getResources().getDrawable(R.drawable.ic_food7);
        Drawable drawable8 = getResources().getDrawable(R.drawable.ic_food8);


        Bitmap bitmap1 = ((BitmapDrawable) drawable1).getBitmap();
        Bitmap bitmap2 = ((BitmapDrawable) drawable2).getBitmap();
        Bitmap bitmap3 = ((BitmapDrawable) drawable3).getBitmap();
        Bitmap bitmap4 = ((BitmapDrawable) drawable4).getBitmap();
        Bitmap bitmap5 = ((BitmapDrawable) drawable5).getBitmap();
        Bitmap bitmap6 = ((BitmapDrawable) drawable6).getBitmap();
        Bitmap bitmap7 = ((BitmapDrawable) drawable7).getBitmap();
        Bitmap bitmap8 = ((BitmapDrawable) drawable8).getBitmap();


        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream4 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream5 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream6 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream7 = new ByteArrayOutputStream();
        ByteArrayOutputStream stream8 = new ByteArrayOutputStream();


        bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, stream1);
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream2);
        bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, stream3);
        bitmap4.compress(Bitmap.CompressFormat.JPEG, 100, stream4);
        bitmap5.compress(Bitmap.CompressFormat.JPEG, 100, stream5);
        bitmap6.compress(Bitmap.CompressFormat.JPEG, 100, stream6);
        bitmap7.compress(Bitmap.CompressFormat.JPEG, 100, stream7);
        bitmap8.compress(Bitmap.CompressFormat.JPEG, 100, stream8);

        byte[] bytes1 = stream1.toByteArray();
        byte[] bytes2 = stream2.toByteArray();
        byte[] bytes3 = stream3.toByteArray();
        byte[] bytes4 = stream4.toByteArray();
        byte[] bytes5 = stream5.toByteArray();
        byte[] bytes6 = stream6.toByteArray();
        byte[] bytes7 = stream7.toByteArray();
        byte[] bytes8 = stream8.toByteArray();


        food1 = new Food(1, "Salmon Teriyaki", 140, "Roasted salon dumped in soa sauce and mint", bytes1);
        food2 = new Food(2, "Grilled Mushroom and Vegetables", 150, "Spcie grills mushrooms, cucumber, apples and lot more", bytes2);
        food3 = new Food(3, "Chicken Overload Meal", 185, "Grilled chicken & tandoori chicken in masala curry", bytes3);
        food4 = new Food(4, "Chinese Egg Fry", 250, "Exotic eggs Fried served steaming hot", bytes4);
        food5 = new Food(5, "Chicken Wraps", 140, "Grilled chicken tikka rool wrapped", bytes5);
        food6 = new Food(6, "Veggie Delight", 230, "Loads of veggies with olives", bytes6);
        food7 = new Food(7, "Seafood Combo", 330, "combo of prawns, scallop, sliced fish, calanmari, potato fries", bytes7);
        food8 = new Food(8, "Full Tandoori", 430, "Chicken roated with lip smacking mayo dressing", bytes8);

    }


}
