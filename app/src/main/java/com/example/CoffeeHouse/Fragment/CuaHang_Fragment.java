package com.example.CoffeeHouse.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.CoffeeHouse.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class CuaHang_Fragment extends Fragment implements OnMapReadyCallback {
    private static final String LOG_TAG ="PopupMenuExample"; ;
    private static CuaHang_Fragment INSTANCE=null;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    View view;
    GoogleMap map;
    MapView mapView;
    Button btnchonkhuvuc_124;
    ListPopupWindow listPopupWindow;
    public CuaHang_Fragment(){
    }
    public static CuaHang_Fragment getINSTANCE(){
        if (INSTANCE==null)
            INSTANCE=new CuaHang_Fragment();
        return INSTANCE;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cuahang_activity, container, false);
        btnchonkhuvuc_124 = v.findViewById(R.id.btnchonkhuvuc_124);
        btnchonkhuvuc_124.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Clicked( );
            }
        });
        return v;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mapView=view.findViewById(R.id.mapsView);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        map=googleMap;
    }
    public void button1Clicked()  {
        //1. Khi kích vào button sẽ tạo 1 menu
        PopupMenu popup = new PopupMenu(CuaHang_Fragment.this.getActivity(), this.btnchonkhuvuc_124);
        popup.inflate(R.menu.munukhuvuc);


        Menu menu = popup.getMenu();

        // com.android.internal.view.menu.MenuBuilder
        Log.i(LOG_TAG, "Menu class: " + menu.getClass().getName());

        // Đăng kí gọi chữ
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return menuItemClicked(item);
            }
        });
        // Hiển thị Popupmenu
        popup.show();
    }
    private boolean menuItemClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.binhduong_124:
                Toast.makeText(CuaHang_Fragment.this.getActivity(), "Bình Dương", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dannang_124:
                Toast.makeText(CuaHang_Fragment.this.getActivity(), "Đà Nẵng", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(CuaHang_Fragment.this.getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
