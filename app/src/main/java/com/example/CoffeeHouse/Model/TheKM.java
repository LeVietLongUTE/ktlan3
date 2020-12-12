package com.example.CoffeeHouse.Model;

import androidx.annotation.NonNull;

import com.example.CoffeeHouse.Controler.Interface.DoAnInterface;
import com.example.CoffeeHouse.Controler.Interface.TheKMInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TheKM {
    String  anhda,gia,tenda,maquanan;
    DatabaseReference nodeRoot;
    public TheKM(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public TheKM(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getMaquanan() {
        return maquanan;
    }

    public void setMaquanan(String maquanan) {
        this.maquanan = maquanan;
    }

    public TheKM(String anhda, String gia, String tenda) {
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



    public void getDanhSachQuanAn(TheKMInterface theKMInterface) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("doann").getChildren()){
                    TheKM doAnModel=i.getValue(TheKM.class);

                    doAnModel.setMaquanan(i.getKey());
                    theKMInterface.getDanhSachQuanAnModel(doAnModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}

