package com.example.demoshop;

import androidx.lifecycle.LiveData;
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
    void InsertFoods(Food... foods);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertFoodList(List<Food> foods);


    @Delete
    void DeleteFood(Food food);

    @Query("SELECT * FROM foods WHERE id = :id")
    Food SelectById(int id);

    @Query("SELECT foodCounter FROM baskets WHERE id = :id")
    int getCountById(int id);

    @Query("select * from foods")
    List<Food> SelectAllFoods();

    @Query("select * from foods")
    LiveData<List<Food>> SelectAllFoodsLive();

}
