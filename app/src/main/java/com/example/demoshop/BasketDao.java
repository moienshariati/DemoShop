package com.example.demoshop;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BasketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertBasket(Basket basket);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertListBasket(List<Basket> basketList);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void InsertFoodCounter(Basket... basket);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void UpdateBasket (Basket basket);

    @Delete
    void deleteBasket(Basket basket);

    @Query("DELETE FROM baskets Where id= :id")
    void  DeleteByID(int id);

    @Query("SELECT * FROM baskets")
    List<Basket> SelectAllBaskets();


    @Query("SELECT * FROM baskets where id= :id")
    Basket SelectById(int id);

//    @Query("SELECT * FROM baskets where id= :id")
//    Basket SelectAllId(int id);

    @Query("SELECT * FROM baskets WHERE foodCounter")
    Basket SelectFoodCounter();

}
