package com.cau.where.navigation;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cau.where.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MypageMywhere extends Fragment implements OnMapReadyCallback {
    MapView mapView2;
    public MypageMywhere(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.mypage_mywhere,container,false);

        mapView2 = (MapView)layout.findViewById(R.id.mywhere_map);
        mapView2.getMapAsync(this);

        return layout;
    }



    @Override
    public void onStart() {
        super.onStart();
        mapView2.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView2.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView2.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView2.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView2.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView2.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView2.onDestroy();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mapView2!=null)
            mapView2.onCreate(savedInstanceState);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng num6 = new LatLng(37.620379, 126.95339);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(num6);
        markerOptions.title("금선사");
        markerOptions.snippet("템플스테이");

        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.where_icon);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 200, 200, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(num6));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
    }

}
