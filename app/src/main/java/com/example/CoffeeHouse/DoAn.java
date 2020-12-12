package com.example.CoffeeHouse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.example.CoffeeHouse.Controler.DoAnController;
public class DoAn extends Fragment {
    DoAnController doAnController_124;
    RecyclerView recyclerview_doan_124;
    ProgressBar progressBar_124;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_doan, container, false);
        recyclerview_doan_124=   (RecyclerView)view.findViewById(R.id.recyclerview_doan);
        progressBar_124=view.findViewById(R.id.progressBar);
return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        doAnController_124= new DoAnController(getContext());
        doAnController_124.getDanhSachQuanAnController(recyclerview_doan_124,progressBar_124);
    }
}