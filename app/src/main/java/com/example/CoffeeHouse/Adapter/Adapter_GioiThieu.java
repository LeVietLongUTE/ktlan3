package com.example.CoffeeHouse.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CoffeeHouse.Model.GioiThieu;
import com.example.CoffeeHouse.Model.KhuyenMai;
import com.example.CoffeeHouse.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class Adapter_GioiThieu extends RecyclerView.Adapter<Adapter_GioiThieu.ViewHolder>{
    List<GioiThieu> cofeModelList;
    int resource;


    public Adapter_GioiThieu(List<GioiThieu> cofeModelList, int resource){
        this.cofeModelList=cofeModelList;
        this.resource=resource;
    }

    @NonNull
    @Override
    public Adapter_GioiThieu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder  ;
    }



    @Override
    public int getItemCount() {
        return cofeModelList.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView anh;
        TextView tieude,noidung,chitiet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anh=itemView.findViewById(R.id.txtimage_124);
            tieude=itemView.findViewById(R.id.tieude_124);
            noidung=itemView.findViewById(R.id.noidung_124);
            chitiet=itemView.findViewById(R.id.chitiet_124);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter_GioiThieu.ViewHolder holder, int position) {
        GioiThieu cofe=cofeModelList.get(position);
        holder.tieude.setText(cofe.getTieude());
        holder.noidung.setText(cofe.getNoidung());
        holder.chitiet.setText(cofe.getChitiet());
            StorageReference storageHinhAnh  = FirebaseStorage.getInstance().getReference().child("hinhanh").child(cofe.getAnh());

        final long ONE_MEGABYTE=1024*1024;
        storageHinhAnh.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.anh.setImageBitmap(bitmap);

    }
        });
    }

}
