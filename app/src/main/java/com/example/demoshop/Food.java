package com.example.demoshop;

import androidx.annotation.InspectableProperty;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "foods")
public class Food {

    @PrimaryKey
    public int id;


    public Food(int id, String foodNames, int foodPrice, String description, byte[] thumbnail) {
        this.id = id;
        this.foodNames = foodNames;
        this.foodPrice = foodPrice;
        this.description = description;
        this.thumbnail = thumbnail;
    }
    @Ignore
    public Food() {
    }

    @ColumnInfo(name = "foodNames")
    public String foodNames;

    @ColumnInfo(name = "foodPrice")
    public int foodPrice;
    @ColumnInfo(name = "tvDescription")
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

