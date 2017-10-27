package com.example.ruslanio.androidhackaton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.AuthorizationManager;
import com.example.ruslanio.androidhackaton.api.authorization.RegistrationBodyRequest;

import butterknife.BindView;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {


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

    private SharedPreferences mPreferences;


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
        switch (v.getId()) {
            case R.id.btn_register:
                mAuthorizationManager.register(getData())
                        .subscribe(response -> {
                                    if (response.getResponseData() == null) {
                                        showSnackbar(response.getError());
                                    } else {
                                        saveToken(response.getResponseData());
                                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }
                        );
                break;
        }
    }

    private void saveToken(String token) {
        mPreferences = getSharedPreferences(MAIN_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(AuthorizationManager.KEY_TOKEN,token);
        editor.commit();
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
