package com.example.CoffeeHouse.Adapter;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.CoffeeHouse.DoAn;
import com.example.CoffeeHouse.Phobien;
import com.example.CoffeeHouse.ThucUong;

public class ViewPaperDatHang extends FragmentStatePagerAdapter {
    public ViewPaperDatHang(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position)
       {
           case 0:
               return new Phobien();
           case 1:
               return new ThucUong();
           case 2:
               return new DoAn();
           default:
               return new Phobien();
       }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="Phổ Biến";
                break;
            case 1:
                title="Thức Uống";
                break;
            case 2:
                title="Đồ Ăn";
                break;

        }

        return title;
    }
}
