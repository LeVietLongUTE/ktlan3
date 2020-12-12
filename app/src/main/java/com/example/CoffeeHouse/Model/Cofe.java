package com.example.CoffeeHouse.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.CoffeeHouse.Controler.Interface.PhobienInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Cofe {
    String  anhcofe,gia,tencofe,maquanan;
    DatabaseReference nodeRoot;
    public Cofe(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public Cofe(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getMaquanan() {
        return maquanan;
    }

    public void setMaquanan(String maquanan) {
        this.maquanan = maquanan;
    }



    public DatabaseReference getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(DatabaseReference nodeRoot) {
        this.nodeRoot = nodeRoot;
    }

    public Cofe(String anhcofe, String gia, String tencofe) {
        this.anhcofe = anhcofe;
        this.gia = gia;
        this.tencofe = tencofe;
    }

    public String getAnhcofe() {
        return anhcofe;
    }

    public void setAnhcofe(String anhcofe) {
        this.anhcofe = anhcofe;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTencofe() {
        return tencofe;
    }

    public void setTencofe(String tencofe) {
        this.tencofe = tencofe;
    }

    public void getDanhSachQuanAn(PhobienInterface phoBienControler_124) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("phobien").getChildren()){
                    Cofe cofeModel=i.getValue(Cofe.class);

                    cofeModel.setMaquanan(i.getKey());
                    phoBienControler_124.getDanhSachQuanAnModel(cofeModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}
