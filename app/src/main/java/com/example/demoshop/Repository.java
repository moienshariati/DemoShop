package com.example.demoshop;

import android.app.Application;

import androidx.lifecycle.LiveData;


import java.util.List;

public class Repository  {
    private FoodDao foodDao;
    private BasketDao basketDao;
    LiveData<List<Food>> listLiveDataFood;
    LiveData<List<Basket>> listLiveDataBasket;


    public Repository(Application application) {
        MyDataBase db = MyDataBase.getInstance(application);
        foodDao=db.getFoodDao();
        listLiveDataFood=foodDao.SelectAllFoodsLive();

        basketDao=db.getBasketDao();

    }

    public LiveData<List<Food>> getListLiveDataFood(){
        return listLiveDataFood;
    }

    public LiveData<List<Basket>> getListLiveDataBasket(){
        return listLiveDataBasket;
    }



}
