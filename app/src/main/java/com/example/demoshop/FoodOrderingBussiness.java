package com.example.demoshop;

import android.content.Context;

public class FoodOrderingBussiness {

    private MyDataBase db;

    public FoodOrderingBussiness(Context context) {
        db = MyDataBase.getInstance(context);

    }

    public int addToBasket(Food selectedFoodPosition) {
        Basket foundRecord = db.getBasketDao().SelectById(selectedFoodPosition.getId());
        if (foundRecord == null) {
            Basket newItem = new Basket(selectedFoodPosition.getId(), selectedFoodPosition.getFoodNames(),
                    selectedFoodPosition.getFoodPrice(), selectedFoodPosition.getDescription(),selectedFoodPosition.getImage());

            db.getBasketDao().InsertBasket(newItem);
            return newItem.foodCounter;

        } else {
            foundRecord.foodCounter++;
            db.getBasketDao().UpdateBasket(foundRecord);

            return foundRecord.foodCounter;
        }

    }
    public void addToBasketFactor(Basket selectedBasketPosition) {
        Basket foundRecord = db.getBasketDao().SelectById(selectedBasketPosition.getId());
        if (foundRecord == null) {
            Basket newItem = new Basket(selectedBasketPosition.getId(), selectedBasketPosition.getFoodName(),
                    selectedBasketPosition.getPrice(), selectedBasketPosition.getDescription(),selectedBasketPosition.getThumbnail());

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
            return 0;
        } else {
            foundRecord.foodCounter--;
            db.getBasketDao().UpdateBasket(foundRecord);
            return foundRecord.foodCounter;
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

