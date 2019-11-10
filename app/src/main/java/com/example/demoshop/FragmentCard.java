package com.example.demoshop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class FragmentCard extends Fragment {
    BottomNavigationView bottomNav;
    RecyclerView recyclerView;
    BasketRecyclerView adapter;
    List<Basket> baskets;
    TextView tvtotalpricebasket;

    ImageView ivDeleteQuery;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);

        recyclerView = v.findViewById(R.id.rv_basket);
        ivDeleteQuery = v.findViewById(R.id.iv_delete_query);
        tvtotalpricebasket = v.findViewById(R.id.tv_total_price_basket);
        bottomNav = v.findViewById(R.id.bttm_nv_main);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        final MyDataBase db = MyDataBase.getInstance(getActivity());


                        baskets = db.getBasketDao().SelectAllBaskets();

                        List<Food> foods = db.getFoodDao().SelectAllFoods();
                        adapter = new BasketRecyclerView(baskets, getActivity(), foods);




                recyclerView.setAdapter(adapter);



//        tvtotalpricebasket.setText(Integer.toString(db.getBasketDao().getTotalPrice()));
//        ivDeleteQuery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                new AlertDialog.Builder(getActivity().getBaseContext())
//                        .setTitle("Are You Sure?")
//                        .setMessage("it's going to delete all your list")
//                        .setPositiveButton("Yes",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        db.getBasketDao().deletListBasket(baskets);
//                                        baskets = db.getBasketDao().SelectAllBaskets();
//                                        adapter.setData(baskets);
//                                    }
//                                })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })
//                        .show();
//
//
//            }
//        });



    return v;
    }


}
