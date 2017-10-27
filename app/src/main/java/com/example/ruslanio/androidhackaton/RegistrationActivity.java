package com.example.ruslanio.androidhackaton;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.AuthorizationManager;
import com.example.ruslanio.androidhackaton.api.authorization.RegistrationBodyRequest;

import butterknife.BindView;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.btn_register)
    Button mRegister;

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


    private AuthorizationManager mAuthorizationManager;

    @Override
    protected void onInit() {
        mRegister.setOnClickListener(this);
        mAuthorizationManager = new AuthorizationManager();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_registration;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                mAuthorizationManager.register(getData())
                        .subscribe(response -> {

                                    saveToken(response.getResponseData());
                                }
                                ,error-> {
                                    showSnackbar("UNKNOWN ERROR");
                                });
                break;
        }
    }

    private void saveToken(String token){
        showSnackbar(token);
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
