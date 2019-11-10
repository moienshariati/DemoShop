package com.example.demoshop;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {Food.class,Basket.class},version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    private static final String DB_NAME="shopDatabase.db";
    private static volatile MyDataBase instance;

    static synchronized MyDataBase getInstance(Context context) {

        if (instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static MyDataBase create(final Context context) {
        return Room.databaseBuilder(
                context,
                MyDataBase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();
    }



    public abstract FoodDao getFoodDao();
    public abstract BasketDao getBasketDao();

}
