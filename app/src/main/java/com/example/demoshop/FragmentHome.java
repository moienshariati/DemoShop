package com.example.demoshop;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.steelkiwi.library.view.BadgeHolderLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment {
    ConstraintLayout rootLayout;
    public Toolbar toolbar;
    Food food1, food2, food3, food4, food5, food6, food7, food8;
    RecyclerView recyclerView;
    FoodRecyclerView adapter;
    List<Food> foodLists;
    ViewModel viewModel;
    //    List<Food> foods;
    private BadgeHolderLayout badgeHolderLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = v.findViewById(R.id.recyclerView);
        rootLayout = v.findViewById(R.id.root_layout);
//        btnMinToCard=v.findViewById(R.id.btn_min_to_card);
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));


        final MyDataBase db = MyDataBase.getInstance(getActivity().getBaseContext());
//                final FoodOrderingBussiness bussiness=new FoodOrderingBussiness(getActivity().getBaseContext());
//        badgeHolderLayout.setCount(bussiness.getTotalCount());

        addStaticData();

        foodLists = new ArrayList<>();

//        List<Food> foods = db.getFoodDao().SelectAllFoods();


        adapter = new FoodRecyclerView(foodLists, rootLayout, getContext());

        recyclerView.setAdapter(adapter);

        viewModel= ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getListLiveDataFood().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foodList) {
                foodLists.addAll(foodList);
                adapter.setData(foodLists);
            }
        });

//        int position=getArguments().getInt("Position");

//
//            int foodCounter=db.getFoodDao().getCountById(0);
//
//            if(foodCounter>=1){
//                btnMinToCard.setVisibility(View.VISIBLE);
//            }else{
//
//                btnMinToCard.setVisibility(View.VISIBLE);
//            }


        return v;
    }

//    private class GetAllFoodsAsyncTask extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            MyDataBase db = MyDataBase.getInstance(getActivity().getBaseContext());
//            List<Food> foods = db.getFoodDao().SelectAllFoods();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            recyclerView.notify();
//        }
//    }
//
//    private class InsertAllFoodsAsyncTask extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            MyDataBase db = MyDataBase.getInstance(getActivity().getBaseContext());
//            addStaticData();
//            db.getFoodDao().InsertFoods(food1, food2, food3, food4, food5, food6, food7, food8);
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            recyclerView.notify();
//        }
//    }


    //    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        rootLayout = view.findViewById(R.id.root_layout);
//        final MyDataBase db = MyDataBase.getInstance(getActivity().getBaseContext());
//        final FoodOrderingBussiness bussiness=new FoodOrderingBussiness(getActivity().getBaseContext());
////        badgeHolderLayout.setCount(bussiness.getTotalCount());
//
//        addStaticData();
//        db.getFoodDao().InsertFoods(food1, food2, food3, food4, food5, food6, food7, food8);
//        List<Food> foods = db.getFoodDao().SelectAllFoods();
//
//        FoodRecyclerView adapter;
//        recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
//        adapter = new FoodRecyclerView(foods, rootLayout, getActivity().getBaseContext());
//        recyclerView.setAdapter(adapter);
//    }
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
