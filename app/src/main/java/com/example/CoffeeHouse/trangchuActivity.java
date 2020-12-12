package com.example.CoffeeHouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.CoffeeHouse.Adapter.ViewPageAdapterTrangChu;


import com.example.CoffeeHouse.Fragment.Dathang_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class trangchuActivity extends AppCompatActivity  {


    private BottomNavigationView mNavigationView_124;
    private ViewPager mViewPager_124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav);
        mNavigationView_124 = findViewById(R.id.bottom_nav);
        mViewPager_124 = findViewById(R.id.view_pager);

        setUpViewPager();

        mNavigationView_124.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tintuc_124:
                        mViewPager_124.setCurrentItem(0);
                        break;
                    case R.id.dathang_124:
                        mViewPager_124.setCurrentItem(1);
                        break;
                    case R.id.cuahang_124:
                        mViewPager_124.setCurrentItem(2);
                        break;
                    case R.id.taikhoang_124:
                        mViewPager_124.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
    private void setUpViewPager(){
        ViewPageAdapterTrangChu viewPageAdapter = new ViewPageAdapterTrangChu(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager_124.setAdapter(viewPageAdapter);

        mViewPager_124.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        mNavigationView_124.getMenu().findItem(R.id.tintuc_124).setChecked(true);
                        break;
                    case 1:
                        mNavigationView_124.getMenu().findItem(R.id.dathang_124).setChecked(true);
                        break;
                    case 2:
                        mNavigationView_124.getMenu().findItem(R.id.cuahang_124).setChecked(true);
                        break;
                    case 3:
                        mNavigationView_124.getMenu().findItem(R.id.taikhoang_124).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
