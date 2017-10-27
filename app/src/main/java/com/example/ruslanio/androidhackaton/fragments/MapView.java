package com.example.ruslanio.androidhackaton.fragments;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class MapView extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_map;
    }

    public static MapView getInstance(){
        return new MapView();
    }
}
