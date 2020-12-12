package com.example.CoffeeHouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class TichDiem extends AppCompatActivity  {
ImageView quaylai_124;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tichdiem);

            quaylai_124=findViewById(R.id.quaylai);
            quaylai_124.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   finish();
                }
            });
    }
}