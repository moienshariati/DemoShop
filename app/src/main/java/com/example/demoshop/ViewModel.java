package com.example.demoshop;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
   Repository repository;
   LiveData<List<Food>> listLiveDataFood;
   LiveData<List<Basket>> listLiveDataBasket;

   //test


    public ViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        listLiveDataFood=repository.getListLiveDataFood();
        listLiveDataBasket=repository.getListLiveDataBasket();
    }

    LiveData<List<Food>> getListLiveDataFood(){
        return listLiveDataFood;
    }
}
