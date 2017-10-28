package com.example.ruslanio.androidhackaton;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.adapters.CarSimpleAdapter;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.api.authorization.models.IssueRoadAccident;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.cars.ResponseDatum;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RoadAccidentFormActivity extends BaseActivity implements View.OnClickListener, CarSimpleAdapter.OnSimpleCarClickListener {

    @BindView(R.id.send_form)
    private Button mSend;

    @BindView(R.id.et_second_reg_number)
    TextInputEditText mSecondRegNumber;

    @BindView(R.id.et_second_phone)
    TextInputEditText mSecondPhone;

    @BindView(R.id.material_damage_to_different_things)
    CheckBox mDamageToThings;

    @BindView(R.id.material_damage_to_transport_except_a_and_b)
    CheckBox mDamageToVehicles;

    @BindView(R.id.et_dtp_place)
    TextInputEditText mDtpAddress;

    @BindView(R.id.et_victim_count)
    TextInputEditText mVictims;

    @BindView(R.id.et_witness_name)
    TextInputEditText mWitnessName;

    @BindView(R.id.et_witness_address)
    TextInputEditText mWitnessAddress;

    @BindView(R.id.tv_car_is_added)
    TextView mCarIsAdded;

    @BindView(R.id.rv_simple_cars)
    RecyclerView mSimpleCars;

    private SharedPreferences mPreferences;
    private NetworkManager mNetworkManager;
    private boolean mIsCarChoosed = false;
    private CarSimpleAdapter mAdapter;

    @Override
    protected void onInit() {
        mSend.setOnClickListener(this);
        mNetworkManager = new NetworkManager();
        mAdapter = new CarSimpleAdapter();
        mAdapter.setOnSimpleCarClickListener(this);

        mSimpleCars.setLayoutManager(new LinearLayoutManager(this));
        mSimpleCars.setAdapter(mAdapter);

        mNetworkManager.getCars(getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .map(carsResponse -> carsResponse.getResponseData())
                .subscribe(responseData -> {
                    mAdapter.setCars(responseData);
                });


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_road_accident_form;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_form:
                if (!mIsCarChoosed) {
                    showSnackbar("Выберете машину!");
                    return;
                }
                break;
        }
    }

    @Override
    public void onCarClick(ResponseDatum car) {
        mIsCarChoosed = true;
        mSimpleCars.setVisibility(View.GONE);
        mCarIsAdded.setVisibility(View.VISIBLE);
    }

    private String getToken() {
        mPreferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);
        String token = mPreferences.getString(NetworkManager.KEY_TOKEN, "no token");
        return token;
    }

    private IssueRoadAccident getRequestBody(){
        IssueRoadAccident issueRoadAccident = new IssueRoadAccident();
        return issueRoadAccident;
    }
}
