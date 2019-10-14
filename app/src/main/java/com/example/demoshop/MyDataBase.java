package com.example.demoshop;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Food.class},version = 1)
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
                DB_NAME).allowMainThreadQueries().build();
    }

    public abstract FoodDao getFoodDao();

}
