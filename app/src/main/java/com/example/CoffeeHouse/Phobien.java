package com.example.CoffeeHouse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.CoffeeHouse.Controler.PhoBienControler;

public class Phobien extends Fragment {

    PhoBienControler phoBienControler_124;
    RecyclerView recyclerview_phobien_124;
    ProgressBar progressBar_124;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_phobien, container, false);
        recyclerview_phobien_124=   (RecyclerView)view.findViewById(R.id.recyclerview_phobien);
        progressBar_124=view.findViewById(R.id.progressBar);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        phoBienControler_124=new PhoBienControler(getContext());
        phoBienControler_124.getDanhSachQuanAnController(recyclerview_phobien_124,progressBar_124);
    }
}