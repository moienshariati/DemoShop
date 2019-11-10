package com.example.demoshop;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.steelkiwi.library.view.BadgeHolderLayout;



public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    BadgeDrawable badge;

    public Toolbar toolbar;
    private BadgeHolderLayout badgeHolderLayout;



//    @Override
//    protected void onResume() {
//        FoodOrderingBussiness bussiness = new FoodOrderingBussiness(MainActivity.this);
//        badgeHolderLayout.setCountWithAnimation(bussiness.getTotalCount());
//        badgeHolderLayout.increment();
//        Toast.makeText(this, "onResume just called", Toast.LENGTH_SHORT).show();
//        super.onResume();
//    }

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new FragmentHome()).commit();

//        rootLayout = findViewById(R.id.root_layout);
        toolbar = findViewById(R.id.toolbar);

        bottomNav = findViewById(R.id.bttm_nv_main);
        bottomNav.setOnNavigationItemSelectedListener(navListenr);
        setSupportActionBar(toolbar);


        FoodOrderingBussiness bussiness=new FoodOrderingBussiness(MainActivity.this);

        bottomNav.getOrCreateBadge(R.id.nav_card).setNumber(bussiness.getTotalCount());





//
//        adapter.onchangeBadge(new FoodRecyclerView.badgeListener() {
//            @Override
//            public void onlistenerBadge(View view) {
//
//
//                badgeHolderLayout.setCountWithAnimation(bussiness.getTotalCount()+1);
//
//                badgeHolderLayout.increment();
//            }
//
//            @Override
//            public void onListenerRemoveBadge(View view) {
//
//                badgeHolderLayout.setCountWithAnimation(bussiness.getTotalCount()-1);
//
//                badgeHolderLayout.decrement();
//            }
//        });
//        badgeHolderLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,BasketActivity.class);
//                startActivity(intent);
//            }
//        });


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListenr = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment =null;
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.nav_card:
                    selectedFragment = new FragmentCard();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment) .commit();
            return true;
        }

    };


            }
