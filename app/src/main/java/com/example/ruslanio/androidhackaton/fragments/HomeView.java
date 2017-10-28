package com.example.ruslanio.androidhackaton.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.RoadAccidentFormActivity;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;

import butterknife.BindView;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class HomeView extends BaseFragment {

    @BindView(R.id.btn_issue_road_accident)
    Button btnIssueRoadAccident;

    @Override
    protected void onInit() {
        super.onInit();

        btnIssueRoadAccident.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), RoadAccidentFormActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    public static HomeView getInstance(){
        return new HomeView();
    }
}
