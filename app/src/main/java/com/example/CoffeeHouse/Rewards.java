package com.example.CoffeeHouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.CoffeeHouse.Adapter.ViewPaperREWARDS;
import com.google.android.material.tabs.TabLayout;

public class Rewards extends AppCompatActivity {
    ImageView quaylai_124;
    TabLayout mtabLayout_124;
    ViewPager viewPager_124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        quaylai_124=findViewById(R.id.quaylai);
        quaylai_124.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mtabLayout_124 =(TabLayout)findViewById(R.id.tablayout);
        viewPager_124=findViewById(R.id.viewpagerMonAn);
        ViewPaperREWARDS viewPaperDatHang=new ViewPaperREWARDS(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager_124.setAdapter(viewPaperDatHang);

        mtabLayout_124.setupWithViewPager(viewPager_124);
    }
}