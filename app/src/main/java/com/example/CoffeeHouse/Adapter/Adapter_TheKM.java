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

import com.example.CoffeeHouse.Model.DoAn;
import com.example.CoffeeHouse.Model.TheKM;
import com.example.CoffeeHouse.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class Adapter_TheKM extends RecyclerView.Adapter<Adapter_TheKM.ViewHolder> {
    List<TheKM> doanModelList;
    int resource;


    public Adapter_TheKM(List<TheKM> doanModelList, int resource){
        this.doanModelList=doanModelList;
        this.resource=resource;
    }
    @NonNull
    @Override
    public Adapter_TheKM.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        Adapter_TheKM.ViewHolder viewHolder=new Adapter_TheKM.ViewHolder(view);

        return viewHolder  ;
    }



    @Override
    public int getItemCount() {
        return doanModelList.size();    }

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
    public void onBindViewHolder(@NonNull Adapter_TheKM.ViewHolder holder, int position) {
        TheKM doAn_124=doanModelList.get(position);
        holder.tenmonan_124.setText(doAn_124.getTenda());
        holder.money_124.setText(doAn_124.getGia());

        StorageReference storageHinhAnh  = FirebaseStorage.getInstance().getReference().child("hinhanh").child(doAn_124.getAnhda());

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
