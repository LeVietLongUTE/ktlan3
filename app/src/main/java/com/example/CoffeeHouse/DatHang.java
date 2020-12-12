package com.example.CoffeeHouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.CoffeeHouse.Adapter.ViewPaperDatHang;
import com.google.android.material.tabs.TabLayout;

public class DatHang extends AppCompatActivity {
    TabLayout mtabLayout_124;
    ViewPager viewPager_124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dathang);

        mtabLayout_124 =(TabLayout)findViewById(R.id.tablayout);
        viewPager_124=findViewById(R.id.viewpagerMonAn);
        ViewPaperDatHang viewPaperDatHang=new ViewPaperDatHang(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager_124.setAdapter(viewPaperDatHang);

        mtabLayout_124.setupWithViewPager(viewPager_124);
    }
}