package com.example.CoffeeHouse.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.CoffeeHouse.DoiUuDai;
import com.example.CoffeeHouse.UuDaiCuaBan;

public class ViewPaperREWARDS extends FragmentStatePagerAdapter {
    public ViewPaperREWARDS(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new DoiUuDai();
            case 1:
                return new UuDaiCuaBan();

            default:
                return new DoiUuDai();
        }
    }
    public int getCount() {
        return 2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="Đổi Ưu Đãi";
                break;
            case 1:
                title="Ưu Đãi Của Bạn";
                break;
        }
        return title;
    }
}
