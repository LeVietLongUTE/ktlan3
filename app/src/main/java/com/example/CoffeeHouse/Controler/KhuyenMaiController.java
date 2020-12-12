package com.example.CoffeeHouse.Controler;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CoffeeHouse.Adapter.Adapter_KhuyenMai;
import com.example.CoffeeHouse.Controler.Interface.KhuyenMaiInterface;
import com.example.CoffeeHouse.Model.KhuyenMai;
import com.example.CoffeeHouse.R;

import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiController {
    Context context;
    KhuyenMai khuyenMai;
    Adapter_KhuyenMai adapter_thucUong_124;

    public KhuyenMaiController(Context context) {
        this.context = context;
        khuyenMai=new KhuyenMai();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List<KhuyenMai> thucUongModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_thucUong_124=new Adapter_KhuyenMai(thucUongModelList, R.layout.chitiet_tintuc_activity);
        recyclerView_124.setAdapter(adapter_thucUong_124);
        KhuyenMaiInterface thucUongInterface_124= new KhuyenMaiInterface() {
            @Override
            public void getDanhSachQuanAnModel(KhuyenMai khuyenMai) {
                thucUongModelList.add(khuyenMai);
                adapter_thucUong_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        khuyenMai.getDanhSachQuanAn(thucUongInterface_124);
    }
}
