package com.example.CoffeeHouse.Model;

import androidx.annotation.NonNull;

import com.example.CoffeeHouse.Controler.Interface.KhuyenMaiInterface;
import com.example.CoffeeHouse.Controler.Interface.ThucUongInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KhuyenMai {
    String  anh,noidung,tieude,maquanan,chitiet;
    DatabaseReference nodeRoot;
    public KhuyenMai(){
        nodeRoot= FirebaseDatabase.getInstance().getReference();
    }
    public KhuyenMai(String maquanan) {
        this.maquanan = maquanan;
    }

    public String getMaquanan() {
        return maquanan;
    }

    public void setMaquanan(String maquanan) {
        this.maquanan = maquanan;
    }

    public KhuyenMai(String anh, String noidung, String tieude,String chitiet) {
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


    public void getDanhSachQuanAn(KhuyenMaiInterface khuyenMaiInterface) {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //lấy danh sách quán ăn
                for (DataSnapshot i:dataSnapshot.child("khuyenmai").getChildren()){
                    KhuyenMai thucUongModel=i.getValue(KhuyenMai.class);

                    thucUongModel.setMaquanan(i.getKey());
                    khuyenMaiInterface.getDanhSachQuanAnModel(thucUongModel);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        nodeRoot.addListenerForSingleValueEvent(valueEventListener);
    }
}
