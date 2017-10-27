package com.example.ruslanio.androidhackaton.fragments;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class PersonalView extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_personal;
    }

    public static PersonalView getInstance(){
        return new PersonalView();
    }
}
