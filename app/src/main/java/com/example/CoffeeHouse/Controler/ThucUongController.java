package com.example.CoffeeHouse.Controler;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.CoffeeHouse.Adapter.Adapter_ThucUong;
import com.example.CoffeeHouse.Controler.Interface.ThucUongInterface;
import com.example.CoffeeHouse.Model.Cofe;
import com.example.CoffeeHouse.Model.ThucUong;
import com.example.CoffeeHouse.R;

import java.util.ArrayList;
import java.util.List;

public class ThucUongController {
    Context context;
    ThucUong thucUong;
    Adapter_ThucUong adapter_thucUong_124;

    public ThucUongController(Context context) {
        this.context = context;
        thucUong=new ThucUong();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List< ThucUong> thucUongModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_thucUong_124=new Adapter_ThucUong(thucUongModelList, R.layout.chitietdathang);
        recyclerView_124.setAdapter(adapter_thucUong_124);
        ThucUongInterface thucUongInterface_124= new ThucUongInterface() {
            @Override
            public void getDanhSachQuanAnModel(ThucUong thucUong) {
                thucUongModelList.add(thucUong);
                adapter_thucUong_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        thucUong.getDanhSachQuanAn(thucUongInterface_124);
    }
}
