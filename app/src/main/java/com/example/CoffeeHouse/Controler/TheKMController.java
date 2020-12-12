package com.example.CoffeeHouse.Controler;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CoffeeHouse.Adapter.Adapter_TheKM;

import com.example.CoffeeHouse.Controler.Interface.TheKMInterface;

import com.example.CoffeeHouse.Model.TheKM;
import com.example.CoffeeHouse.R;

import java.util.ArrayList;
import java.util.List;

public class TheKMController {
    Context context;
    TheKM doAn ;
    Adapter_TheKM adapter_doAn_124;

    public TheKMController(Context context) {
        this.context = context;
        doAn=new TheKM();
    }
    public void getDanhSachQuanAnController(RecyclerView recyclerView_124, final ProgressBar progressBar){
        final List<TheKM> doAnModelList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView_124.setLayoutManager(layoutManager);
        adapter_doAn_124=new Adapter_TheKM(doAnModelList, R.layout.chitietuudai);
        recyclerView_124.setAdapter(adapter_doAn_124);
        TheKMInterface doAnInterface_124= new TheKMInterface() {
            @Override
            public void getDanhSachQuanAnModel(TheKM theKM) {
                doAnModelList.add(theKM);
                adapter_doAn_124.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        };
        doAn.getDanhSachQuanAn(doAnInterface_124);
    }
}
