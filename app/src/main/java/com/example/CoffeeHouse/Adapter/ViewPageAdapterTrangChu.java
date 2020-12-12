package com.example.CoffeeHouse.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.CoffeeHouse.DatHang;
import com.example.CoffeeHouse.Fragment.CuaHang_Fragment;
import com.example.CoffeeHouse.Fragment.Dathang_Fragment;
import com.example.CoffeeHouse.Fragment.TaiKhoang_Fragment;
import com.example.CoffeeHouse.Fragment.Tintuc_Fragment;

public class ViewPageAdapterTrangChu extends FragmentStatePagerAdapter {
    public ViewPageAdapterTrangChu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tintuc_Fragment();
            case 1:
                return new Dathang_Fragment();
            case 2:
                return new CuaHang_Fragment();
            case 3:
                return new TaiKhoang_Fragment();

            default:
                return new Tintuc_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
