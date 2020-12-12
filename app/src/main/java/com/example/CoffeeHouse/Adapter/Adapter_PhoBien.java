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

import com.example.CoffeeHouse.Model.Cofe;
import com.example.CoffeeHouse.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class Adapter_PhoBien  extends RecyclerView.Adapter<Adapter_PhoBien.ViewHolder>{
    List<Cofe> cofeModelList;
    int resource;


    public Adapter_PhoBien(List<Cofe>cofeModelList,int resource){
        this.cofeModelList=cofeModelList;
        this.resource=resource;
    }
    @NonNull
    @Override
    public Adapter_PhoBien.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder  ;
    }



    @Override
    public int getItemCount() {
        return cofeModelList.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView txtimage_124;
        TextView tenmonan_124,money_124;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtimage_124=itemView.findViewById(R.id.txtimage);
            tenmonan_124=itemView.findViewById(R.id.tenmonan);
            money_124=itemView.findViewById(R.id.money);

        }
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter_PhoBien.ViewHolder holder, int position) {
        Cofe cofe=cofeModelList.get(position);
        holder.tenmonan_124.setText(cofe.getTencofe());
        holder.money_124.setText(cofe.getGia());

            StorageReference storageHinhAnh  = FirebaseStorage.getInstance().getReference().child("hinhanh").child(cofe.getAnhcofe());

        final long ONE_MEGABYTE=1024*1024;
        storageHinhAnh.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.txtimage_124.setImageBitmap(bitmap);

    }
        });
    }

}
