package com.example.ruslanio.androidhackaton.abstracts;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String MAIN_PREF_NAME = "main_pref";
    public static final String IS_REGISTERED_KEY = "is_registered";
    public static final String IS_LOGGED_KEY = "is_logged";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        onInit();
    }


    protected abstract void onInit();

    @LayoutRes
    protected abstract int getLayout();

    public void showToast(@StringRes int text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void showSnackbar(@StringRes int text) {
        Snackbar.make(getWindow().getDecorView(), text, BaseTransientBottomBar.LENGTH_LONG).show();
    }

    public void showSnackbar(String text) {
        Snackbar.make(getWindow().getDecorView(), text, BaseTransientBottomBar.LENGTH_LONG).show();
    }

}
