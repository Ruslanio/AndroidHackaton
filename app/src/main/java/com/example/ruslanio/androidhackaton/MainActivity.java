package com.example.ruslanio.androidhackaton;

import android.content.SharedPreferences;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.AuthorizationManager;

public class MainActivity extends BaseActivity {

    private SharedPreferences mPreferences;

    @Override
    protected void onInit() {
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private String getToken(){
        mPreferences = getSharedPreferences(MAIN_PREF_NAME,MODE_PRIVATE);
        String token = mPreferences.getString(AuthorizationManager.KEY_TOKEN,"no token");
        return token;
    }
}
