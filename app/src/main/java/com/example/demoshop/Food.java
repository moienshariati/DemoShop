package com.example.demoshop;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "foods")
public class Food {

    @PrimaryKey(autoGenerate = true)
    public int id;


    public Food(int id, String foodNames, int foodPrice, String description, byte[] thumbnail) {
        this.id = id;
        this.foodNames = foodNames;
        this.foodPrice = foodPrice;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public Food() {
    }

    @ColumnInfo(name = "foodNames")
    public String foodNames;

    @ColumnInfo(name = "foodPrice")
    public int foodPrice;
    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "thumbnail",typeAffinity = ColumnInfo.BLOB)
    public byte[] thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return thumbnail;
    }
}

