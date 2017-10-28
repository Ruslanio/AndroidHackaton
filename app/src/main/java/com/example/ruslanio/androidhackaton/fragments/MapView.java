package com.example.ruslanio.androidhackaton.fragments;

import android.content.Context;
import android.graphics.Color;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(55.787916, 49.123263), 12.0f));
    }

    private void addCurrentAccidents() {
        NetworkManager manager = new NetworkManager();
        manager.getCurrentAccident(getContext()
                .getSharedPreferences(MAIN_PREF_NAME, Context.MODE_PRIVATE)
                .getString(NetworkManager.KEY_TOKEN, ""))
                .flatMap(currentAccidentsResponse -> Observable.fromIterable(currentAccidentsResponse.getResponseData()))
                .map(responseDatum -> new LatLng(responseDatum.getLatitude(), responseDatum.getLongitude()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(latLng -> {
                    map.addMarker(new MarkerOptions().position(latLng));
                }, t -> {
                    t.printStackTrace();
                });
    }

    private void addDangerousAreas() {
        NetworkManager manager = new NetworkManager();
        manager.getDangerousAreas(getContext()
                .getSharedPreferences(MAIN_PREF_NAME, Context.MODE_PRIVATE)
                .getString(NetworkManager.KEY_TOKEN, ""))
                .flatMap(dangerousAreasResponse -> Observable.fromIterable(dangerousAreasResponse.getResponseData()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseDatum -> {
                    LatLng latLng = new LatLng(responseDatum.getLatitude(), responseDatum.getLongitude());
                    CircleOptions circleOptions = new CircleOptions()
                            .center(latLng)
                            .fillColor(Color.argb(100, 255, 0, 0))
                            .strokeWidth(2)
                            .radius(responseDatum.getRadius());
                    map.addCircle(circleOptions);
                }, t -> {
                    t.printStackTrace();
                });
    }
}
