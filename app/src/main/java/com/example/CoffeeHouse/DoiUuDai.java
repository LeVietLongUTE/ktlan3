package com.example.CoffeeHouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CoffeeHouse.Controler.PhoBienControler;
import com.example.CoffeeHouse.Controler.TheKMController;

public class DoiUuDai  extends Fragment {
    TheKMController quanUuDaiController_124;
    RecyclerView recyclerview_uudai_124;
    ProgressBar progressBar_124;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.doiuudai, container, false);
        recyclerview_uudai_124=   (RecyclerView)view.findViewById(R.id.recyclerview_uudai);
        progressBar_124=view.findViewById(R.id.progressBar);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        quanUuDaiController_124=new TheKMController(getContext());
        quanUuDaiController_124.getDanhSachQuanAnController(recyclerview_uudai_124,progressBar_124);
    }
}
