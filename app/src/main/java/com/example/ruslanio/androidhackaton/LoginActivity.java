package com.example.ruslanio.androidhackaton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.AuthorizationManager;
import com.example.ruslanio.androidhackaton.api.authorization.SignInRequest;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

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

        SharedPreferences prefs = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);
        if (prefs.getBoolean(IS_LOGGED_KEY, false)) {
            goToPersonal();
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent1);
                signIn();
                break;
            case R.id.btn_sign_up:
                /*Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);*/
                break;
        }
    }

    private void signIn() {
        SignInRequest request = new SignInRequest(mLogin.getText().toString(), mRegistration.getText().toString());
        AuthorizationManager manager = new AuthorizationManager();
        manager.signIn(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(signInResponse -> {
                    if (signInResponse.getError() != null) {
                        mLogin.setText("");
                        mRegistration.setText("");
                        showSnackbar(R.string.signin_error);
                    } else {
                        goToPersonal();
                        saveToken(signInResponse.getResponseData());
                        setLogged();
                    }
                });
    }

    private void goToPersonal() {
        Intent intentToPersonal = new Intent(getApplicationContext(), PersonalActivity.class);
        startActivity(intentToPersonal);
        finish();
    }

    private void saveToken(String token) {
        SharedPreferences preferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AuthorizationManager.KEY_TOKEN, token);
        editor.commit();
    }

    private void setLogged() {
        SharedPreferences preferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_LOGGED_KEY, true);
        editor.commit();
    }

}
