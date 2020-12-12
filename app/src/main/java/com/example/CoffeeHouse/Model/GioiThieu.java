package com.example.CoffeeHouse.Model;

import androidx.annotation.NonNull;

import com.example.CoffeeHouse.Controler.Interface.GioiThieuInterface;
import com.example.CoffeeHouse.Controler.Interface.KhuyenMaiInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GioiThieu {
    String  anh,noidung,tieude,maquanan,chitiet;
    DatabaseReference nodeRoot;
    public GioiThieu(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public GioiThieu(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getMaquanan() {
        return maquanan;
    }

    public void setMaquanan(String maquanan) {
        this.maquanan = maquanan;
    }

    public GioiThieu(String anh, String noidung, String tieude, String chitiet) {
        this.anh = anh;
        this.noidung = noidung;
        this.tieude = tieude;
        this.chitiet = chitiet;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public DatabaseReference getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(DatabaseReference nodeRoot) {
        this.nodeRoot = nodeRoot;
    }


    public void getDanhSachQuanAn(GioiThieuInterface gioiThieuInterface) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("gioithieu").getChildren()){
                    GioiThieu thucUongModel=i.getValue(GioiThieu.class);

                    thucUongModel.setMaquanan(i.getKey());
                    gioiThieuInterface.getDanhSachQuanAnModel(thucUongModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}
