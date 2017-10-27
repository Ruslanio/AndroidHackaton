package com.example.ruslanio.androidhackaton;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.AuthorizationManager;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    private SharedPreferences mPreferences;

    @Override
    protected void onInit() {
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    private String getToken(){
        mPreferences = getSharedPreferences(MAIN_PREF_NAME,MODE_PRIVATE);
        String token = mPreferences.getString(AuthorizationManager.KEY_TOKEN,"no token");
        return token;
    }
}
