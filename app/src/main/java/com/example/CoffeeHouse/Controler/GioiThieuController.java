package com.example.CoffeeHouse.Controler;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CoffeeHouse.Adapter.Adapter_GioiThieu;
import com.example.CoffeeHouse.Controler.Interface.GioiThieuInterface;
import com.example.CoffeeHouse.Model.GioiThieu;
import com.example.CoffeeHouse.R;

import java.util.ArrayList;
import java.util.List;

public class GioiThieuController {
    Context context;
    GioiThieu khuyenMai;
    Adapter_GioiThieu adapter_thucUong_124;

    public GioiThieuController(Context context) {
        this.context = context;
        khuyenMai=new GioiThieu();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List<GioiThieu> thucUongModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_thucUong_124=new Adapter_GioiThieu(thucUongModelList, R.layout.chitiet_tintuc_activity);
        recyclerView_124.setAdapter(adapter_thucUong_124);
        GioiThieuInterface thucUongInterface_124= new GioiThieuInterface() {
            @Override
            public void getDanhSachQuanAnModel(GioiThieu khuyenMai) {
                thucUongModelList.add(khuyenMai);
                adapter_thucUong_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        khuyenMai.getDanhSachQuanAn(thucUongInterface_124);
    }
}
