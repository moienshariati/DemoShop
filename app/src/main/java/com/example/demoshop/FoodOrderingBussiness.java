package com.example.demoshop;

import android.content.Context;

public class FoodOrderingBussiness {

    private MyDataBase db;

    public FoodOrderingBussiness(Context context) {
        db = MyDataBase.getInstance(context);

    }

    public void addToBasket(Food selectedFoodPosition) {
        Basket foundRecord = db.getBasketDao().SelectById(selectedFoodPosition.getId());
        if (foundRecord == null) {
            Basket newItem = new Basket(selectedFoodPosition.getId(), selectedFoodPosition.getFoodNames(),
                    selectedFoodPosition.getFoodPrice(), selectedFoodPosition.getDescription());

            db.getBasketDao().InsertBasket(newItem);

        } else {
            foundRecord.foodCounter++;
            db.getBasketDao().UpdateBasket(foundRecord);
        }

    }

    public int removeItemFromBasket(int id) {

        Basket foundRecord = db.getBasketDao().SelectById(id);

        if (foundRecord == null) {
            return 0;

            //Toast.makeText(v.getContext(), "there is no item", Toast.LENGTH_SHORT).show();

        } else if (foundRecord.foodCounter <= 1) {
            db.getBasketDao().DeleteByID(foundRecord.id);
            return 1;
        } else {
            foundRecord.foodCounter--;
            db.getBasketDao().UpdateBasket(foundRecord);
            return 1;
        }
    }

    //teded aghlame factor
    public int getTotalCount() {
        return db.getBasketDao().getTotalCount();
    }

    //jame mablaghe factor
    public int getTotalPrice() {
        return db.getBasketDao().getTotalPrice();
    }
}

