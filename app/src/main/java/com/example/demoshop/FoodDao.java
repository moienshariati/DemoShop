package com.example.demoshop;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertFood(Food food);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertFoodList(List<Food> foods);

    @Delete
    void DeleteFood(Food food);

    @Query("SELECT * FROM Food WHERE id = :id")
    Food SelectById(int id);

    @Query("SELECT * FROM Food")
    List<Food> SelectAllFoods();

}
