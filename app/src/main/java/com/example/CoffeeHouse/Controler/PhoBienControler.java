package com.example.CoffeeHouse.Controler;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CoffeeHouse.Adapter.Adapter_PhoBien;
import com.example.CoffeeHouse.Adapter.ViewPaperDatHang;
import com.example.CoffeeHouse.Controler.Interface.PhobienInterface;

import com.example.CoffeeHouse.Model.Cofe;
import com.example.CoffeeHouse.R;

import java.util.ArrayList;
import java.util.List;

public class PhoBienControler {
    Context context;
        Cofe cofe;
    Adapter_PhoBien adapter_phoBien_124;

    public PhoBienControler(Context context) {
        this.context = context;
        cofe=new Cofe();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List<Cofe> cofeModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_phoBien_124=new Adapter_PhoBien(cofeModelList, R.layout.chitietdathang);
        recyclerView_124.setAdapter(adapter_phoBien_124);
        PhobienInterface phobienInterface= new PhobienInterface() {
            @Override
            public void getDanhSachQuanAnModel(Cofe cofe) {
                cofeModelList.add(cofe);
                adapter_phoBien_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        cofe.getDanhSachQuanAn(phobienInterface);
    }
}
