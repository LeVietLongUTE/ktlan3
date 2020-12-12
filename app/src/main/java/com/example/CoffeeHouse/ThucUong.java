package com.example.CoffeeHouse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.example.CoffeeHouse.Controler.ThucUongController;

public class ThucUong extends Fragment {
    ThucUongController thucUongController_124;
    RecyclerView recyclerview_thucuong_124;
    ProgressBar progressBar_124;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_thucuong, container, false);
        recyclerview_thucuong_124=   (RecyclerView)view.findViewById(R.id.recyclerview_thucuong);
        progressBar_124=view.findViewById(R.id.progressBar);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        thucUongController_124= new ThucUongController(getContext());
        thucUongController_124.getDanhSachQuanAnController(recyclerview_thucuong_124,progressBar_124);
    }


}