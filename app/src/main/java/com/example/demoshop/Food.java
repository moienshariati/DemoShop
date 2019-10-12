package com.example.demoshop;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Food {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public Food(int id, String foodNames, String foodPrice) {
        this.id = id;
        this.foodNames = foodNames;
        this.foodPrice = foodPrice;
    }

    public String foodNames;

    public String foodPrice;

}

