package com.example.CoffeeHouse.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.CoffeeHouse.Adapter.Adapter_KhuyenMai;
import com.example.CoffeeHouse.Controler.GioiThieuController;
import com.example.CoffeeHouse.Controler.KhuyenMaiController;
import com.example.CoffeeHouse.Controler.PhoBienControler;
import com.example.CoffeeHouse.CouPon;
import com.example.CoffeeHouse.DatHang;
import com.example.CoffeeHouse.R;
import com.example.CoffeeHouse.Rewards;
import com.example.CoffeeHouse.TichDiem;


import java.util.ArrayList;

public class Tintuc_Fragment extends Fragment implements View.OnClickListener {
    CardView quetma_124,dathang_124,coupon_124,rewars_124;
    KhuyenMaiController uuDaiController_124;
    GioiThieuController gioiThieuController_124;
    RecyclerView recyclerview_uudai_124,recyclerview_gioithieu_124;
    ProgressBar progressBar_124,progressBar_gioithieu_124;
    ArrayList<String> arrayList;
  private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trangchu_activity, container, false);
        quetma_124=view.findViewById(R.id.quetma_124);
        dathang_124=view.findViewById(R.id.dathang_124);
        coupon_124=view.findViewById(R.id.coupon_124);
        rewars_124=view.findViewById(R.id.rewars_124);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_single_choice,arrayList);
        quetma_124.setOnClickListener(this);
        dathang_124.setOnClickListener(this);
        coupon_124.setOnClickListener(this);
        rewars_124.setOnClickListener(this);

        recyclerview_uudai_124=   (RecyclerView)view.findViewById(R.id.recyclerview_uudai);
        progressBar_124=view.findViewById(R.id.progressBar);
        recyclerview_gioithieu_124=   (RecyclerView)view.findViewById(R.id.recyclerview_uudai1);
        progressBar_gioithieu_124=view.findViewById(R.id.progressBar1);
        return view;

    }
    @Override
    public void onStart() {
        super.onStart();
        uuDaiController_124= new KhuyenMaiController(getContext());
        uuDaiController_124.getDanhSachQuanAnController(recyclerview_uudai_124,progressBar_124);
        gioiThieuController_124= new GioiThieuController(getContext());
        gioiThieuController_124.getDanhSachQuanAnController(recyclerview_gioithieu_124,progressBar_gioithieu_124);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.quetma_124:
                quetma_124.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), TichDiem.class);
                        startActivity(intent);
                    }
                });

            case R.id.dathang_124:
                dathang_124.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(),DatHang.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.coupon_124:
                coupon_124.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), CouPon.class);
                        startActivity(intent);
                    }
                });
            case R.id.rewars_124:
                rewars_124.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), Rewards.class);
                        startActivity(intent);
                    }
                });
        }
    }

    private void replaceFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_chinh, fragment, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }


}
