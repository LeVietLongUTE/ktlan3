package com.example.CoffeeHouse.Model;

import androidx.annotation.NonNull;

import com.example.CoffeeHouse.Controler.Interface.ThucUongInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThucUong {
    String  anhth,gia,tenth,maquanan;
    DatabaseReference nodeRoot;
    public ThucUong(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public ThucUong(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getMaquanan() {
        return maquanan;
    }

    public void setMaquanan(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getAnhth() {
        return anhth;
    }

    public void setAnhth(String anhth) {
        this.anhth = anhth;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTenth() {
        return tenth;
    }

    public void setTenth(String tenth) {
        this.tenth = tenth;
    }

    public ThucUong(String anhth, String gia, String tenth) {
        this.anhth = anhth;
        this.gia = gia;
        this.tenth = tenth;
    }

    public DatabaseReference getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(DatabaseReference nodeRoot) {
        this.nodeRoot = nodeRoot;
    }


    public void getDanhSachQuanAn(ThucUongInterface thucUongInterface_124) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("thucuong").getChildren()){
                    ThucUong thucUongModel=i.getValue(ThucUong.class);

                    thucUongModel.setMaquanan(i.getKey());
                    thucUongInterface_124.getDanhSachQuanAnModel(thucUongModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}
