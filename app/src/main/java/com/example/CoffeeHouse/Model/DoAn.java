package com.example.CoffeeHouse.Model;

import androidx.annotation.NonNull;

import com.example.CoffeeHouse.Controler.Interface.DoAnInterface;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoAn {
    String  anhda,gia,tenda,maquanan;
    DatabaseReference nodeRoot;
    public DoAn(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public DoAn(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getMaquanan() {
        return maquanan;
    }

    public void setMaquanan(String maquanan) {
        this.maquanan = maquanan;
    }

    public DoAn(String anhda, String gia, String tenda) {
        this.anhda = anhda;
        this.gia = gia;
        this.tenda = tenda;
    }

    public String getAnhda() {
        return anhda;
    }

    public void setAnhda(String anhda) {
        this.anhda = anhda;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTenda() {
        return tenda;
    }

    public void setTenda(String tenda) {
        this.tenda = tenda;
    }

    public DatabaseReference getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(DatabaseReference nodeRoot) {
        this.nodeRoot = nodeRoot;
    }



    public void getDanhSachQuanAn(DoAnInterface doAnInterface_124) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("doan").getChildren()){
                    DoAn doAnModel=i.getValue(DoAn.class);

                    doAnModel.setMaquanan(i.getKey());
                    doAnInterface_124.getDanhSachQuanAnModel(doAnModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}

