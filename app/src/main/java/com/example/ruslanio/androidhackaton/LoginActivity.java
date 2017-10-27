package com.example.ruslanio.androidhackaton;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.btn_sign_in)
    Button mSignIn;
    @BindView(R.id.btn_sign_up)
    Button mSignUp;
    @BindView(R.id.et_login)
    TextInputEditText mLogin;
    @BindView(R.id.et_password)
    TextInputEditText mRegistration;



    @Override
    protected void onInit() {
        mSignUp.setOnClickListener(this);
        mSignIn.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_in:
                break;
            case R.id.btn_sign_up:
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
