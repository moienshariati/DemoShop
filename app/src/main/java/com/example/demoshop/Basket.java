package com.example.demoshop;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "baskets")
public class Basket {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "foodIds")
    public int foodId;

    @ColumnInfo(name = "foodNames")
    public String foodName;

    @ColumnInfo(name = "foodCounter")
    public int foodCounter;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "description")
    public String description;

    @Ignore
    public Basket(int id, int foodId, String foodName, int foodCounter, int price, String description) {
        this.id = id;
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodCounter = foodCounter;
        this.price = price;
        this.description = description;

    }

    public Basket(int id,String foodName, int price, String description) {
        this.foodName = foodName;
        this.price = price;
        this.description = description;
        this.id=id;
        foodCounter=1;

    }
    @Ignore
    public Basket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCounter() {
        return foodCounter;
    }

    public void setFoodCounter(int foodCounter) {
        this.foodCounter = foodCounter;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
