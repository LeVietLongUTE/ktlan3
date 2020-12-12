package com.example.CoffeeHouse.Controler;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.CoffeeHouse.Adapter.Adapter_DoAn;
import com.example.CoffeeHouse.Controler.Interface.DoAnInterface;
import com.example.CoffeeHouse.Model.DoAn;
import com.example.CoffeeHouse.R;

import java.util.ArrayList;
import java.util.List;

public class DoAnController {
    Context context;
    DoAn doAn ;
    Adapter_DoAn adapter_doAn_124;

    public DoAnController(Context context) {
        this.context = context;
        doAn=new DoAn();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List<DoAn> doAnModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_doAn_124=new Adapter_DoAn(doAnModelList, R.layout.chitietdathang);
        recyclerView_124.setAdapter(adapter_doAn_124);
        DoAnInterface doAnInterface_124= new DoAnInterface() {
            @Override
            public void getDanhSachQuanAnModel(DoAn doAn) {
                doAnModelList.add(doAn);
                adapter_doAn_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        doAn.getDanhSachQuanAn(doAnInterface_124);
    }
}
