package com.example.ruslanio.androidhackaton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.api.authorization.models.RegistrationBodyRequest;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.btn_register)
    Button mRegister;
    @BindView(R.id.btn_skip)
    Button mSkip;

    @BindView(R.id.et_first_name)
    TextInputEditText mFirstName;
    @BindView(R.id.et_last_name)
    TextInputEditText mLastName;
    @BindView(R.id.et_middle_name)
    TextInputEditText mMiddleName;
    @BindView(R.id.et_email)
    TextInputEditText mEmail;
    @BindView(R.id.et_phone)
    TextInputEditText mPhone;
    @BindView(R.id.et_password)
    TextInputEditText mPassword;

    private SharedPreferences mPreferences;


    private NetworkManager mNetworkManager;

    @Override
    protected void onInit() {
        mRegister.setOnClickListener(this);
        mSkip.setOnClickListener(this);
        mNetworkManager = new NetworkManager();

        mPreferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);

        if (mPreferences.getBoolean(IS_REGISTERED_KEY, false) || mPreferences.getBoolean(IS_LOGGED_KEY, false)) {
            goToLogin();
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_registration;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                mNetworkManager.register(getData())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(response -> {
                                    if (response.getResponseData() == null) {
                                        showSnackbar(response.getError());
                                    } else {
                                        saveToken(response.getResponseData());
                                        setRegisteredAndLogged();
                                        goToLogin();
                                    }
                                }
                        );
                break;
            case R.id.btn_skip:
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
        }
    }

    private void saveToken(String token) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(NetworkManager.KEY_TOKEN,token);
        editor.commit();
    }

    private void setRegisteredAndLogged() {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(IS_REGISTERED_KEY, true);
        editor.putBoolean(IS_LOGGED_KEY, true);
        editor.commit();
    }

    private void goToLogin() {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private RegistrationBodyRequest getData() {
        RegistrationBodyRequest registrationBodyRequest = new RegistrationBodyRequest();
        registrationBodyRequest.setFirstName(mFirstName.getText().toString());
        registrationBodyRequest.setLastName(mLastName.getText().toString());
        registrationBodyRequest.setMiddleName(mMiddleName.getText().toString());
        registrationBodyRequest.setEmail(mEmail.getText().toString());
        registrationBodyRequest.setPassword(mPassword.getText().toString());
        registrationBodyRequest.setPhone(mPhone.getText().toString());
        return registrationBodyRequest;
    }
}
