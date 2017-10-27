package com.example.ruslanio.androidhackaton.abstracts;

import android.os.Bundle;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        onInit();
    }


    protected abstract void onInit();


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
