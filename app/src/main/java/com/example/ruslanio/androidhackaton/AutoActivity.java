package com.example.ruslanio.androidhackaton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.api.authorization.models.PostCarRequest;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class AutoActivity extends BaseActivity {

    private SharedPreferences preferences;

    @BindView(R.id.save_car)
    Button btnSaveCar;

    @BindView(R.id.et_mark)
    TextInputEditText mMark;

    @BindView(R.id.et_model)
    TextInputEditText mModel;

    @BindView(R.id.et_reg_number)
    TextInputEditText mRegNumber;

    @BindView(R.id.et_year)
    TextInputEditText mYear;

    @BindView(R.id.et_horse_power)
    TextInputEditText mHorsePower;

    @BindView(R.id.et_insurance_number)
    TextInputEditText mInsuranceNumber;

    @BindView(R.id.et_insurance_serial)
    TextInputEditText mInsuranceSerial;

    @BindView(R.id.et_vin_number)
    TextInputEditText mVinNumber;

    @BindView(R.id.et_pts_number)
    TextInputEditText mPtsNumber;

    @BindView(R.id.et_pts_serial)
    TextInputEditText mPtsSerial;

    @BindView(R.id.et_pts_who)
    TextInputEditText mPtsWho;

    @Override
    protected void onInit() {
        preferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);

        if (preferences.getBoolean(IS_AUTO, false)) {
            goToMain();
        }

        btnSaveCar.setOnClickListener(v -> {
            NetworkManager manager = new NetworkManager();
            manager.addCar(preferences.getString(NetworkManager.KEY_TOKEN, ""), getData())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.getError() == null){
                            showSnackbar(response.getError());
                        } else {
                            setIsAuto();
                            goToMain();
                        }
                    }, Throwable::printStackTrace);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_auto;
    }

    public PostCarRequest getData() {
        PostCarRequest postCarRequest = new PostCarRequest();
        try {
            postCarRequest.setCarMark(mMark.getText().toString());
            postCarRequest.setCarModel(mModel.getText().toString());
            postCarRequest.setCarNumber(mRegNumber.getText().toString());
            postCarRequest.setCarYearOfBuilding(mYear.getText().toString());
            postCarRequest.setHorsePower(Integer.parseInt(mHorsePower.getText().toString()));
            postCarRequest.setInsurancePolicyNumber(mInsuranceNumber.getText().toString());
            postCarRequest.setInsurancePolicySerial(mInsuranceSerial.getText().toString());
            postCarRequest.setVinNumber(mVinNumber.getText().toString());
            postCarRequest.setPtsNumber(mPtsNumber.getText().toString());
            postCarRequest.setPtsSerialNumber(mPtsSerial.getText().toString());
            postCarRequest.setWhoGivedPts(mPtsWho.getText().toString());
        } catch (NumberFormatException e){
            showSnackbar("Одно из полей введено неправильно");
        }
        return postCarRequest;
    }

    private void setIsAuto() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_AUTO, true);
        editor.commit();
    }

    private void goToMain() {
        Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goToMain);
        finish();
    }
}
