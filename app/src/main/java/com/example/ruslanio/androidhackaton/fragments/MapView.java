package com.example.ruslanio.androidhackaton.fragments;

import android.graphics.Color;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class MapView extends BaseFragment implements OnMapReadyCallback {

    private GoogleMap map;

    @Override
    protected void onInit() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_map;
    }

    public static MapView getInstance(){
        return new MapView();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        addCurrentAccidents();
        addDangerousAreas();
    }

    private void addCurrentAccidents() {

    }

    private void addDangerousAreas() {
        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(55.787916, 49.123263))
                .fillColor(Color.argb(128, 255, 0, 0))
                .strokeWidth(1)
                .radius(50);
        map.addCircle(circleOptions);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(55.787916, 49.123263), 15.0f));
    }
}
