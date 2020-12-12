package com.example.CoffeeHouse.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.CoffeeHouse.Adapter.ViewPaperDatHang;
import com.example.CoffeeHouse.DatHang;
import com.example.CoffeeHouse.R;
import com.google.android.material.tabs.TabLayout;

public class Dathang_Fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.giohang, container, false);

        return v;
    }
}
