package com.example.ruslanio.androidhackaton.fragments;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class CarsView extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_cars;
    }

    public static CarsView getInstance(){
        return new CarsView();
    }
}
