package com.example.demoshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    List<Food> foodList;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDataBase db = MyDataBase.getInstance(MainActivity.this);


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


        Food food1 = new Food(1, "Salmon Teriyaki", 140, "Roasted salon dumped in soa sauce and mint", bytes1);
        Food food2 = new Food(2, "Grilled Mushroom and Vegetables", 150, "Spcie grills mushrooms, cucumber, apples and lot more", bytes2);
        Food food3 = new Food(3, "Chicken Overload Meal", 185, "Grilled chicken & tandoori chicken in masala curry", bytes3);
        Food food4 = new Food(4, "Chinese Egg Fry", 250, "Exotic eggs Fried served steaming hot", bytes4);
        Food food5 = new Food(5, "Chicken Wraps", 140, "Grilled chicken tikka rool wrapped", bytes5);
        Food food6 = new Food(6, "Veggie Delight", 230, "Loads of veggies with olives", bytes6);
        Food food7 = new Food(7, "Seafood Combo", 330, "combo of prawns, scallop, sliced fish, calanmari, potato fries", bytes7);
        Food food8 = new Food(8, "Full Tandoori", 430, "Chicken roated with lip smacking mayo dressing", bytes8);

        db.getFoodDao().InsertFoods(food1, food2, food3, food4, food5, food6, food7, food8);


        List<Food> foods = db.getFoodDao().SelectAllFoods();

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FoodRecyclerView(foods);
        recyclerView.setAdapter(adapter);

//        String info = "";
//
//
//        for (Food food : foods) {
//            int id = food.getId();
//            String name = food.getFoodNames();
//            String description = food.getDescription();
//
//
//            info = info + "\n\n+" + ":id " + id + "\n\n" + name + "\n\n" + "description" + "\n\n" + description;

    }


}
