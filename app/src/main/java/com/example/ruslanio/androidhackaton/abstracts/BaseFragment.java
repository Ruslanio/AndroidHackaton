package com.example.ruslanio.androidhackaton.abstracts;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public abstract class BaseFragment extends Fragment{
    protected static final String MAIN_PREF_NAME = "main_pref";

    @LayoutRes
    protected abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onInit();
    }

    protected void onInit() {
    }

    public void showToast(@StringRes int text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    public void showSnackbar(@StringRes int text) {
        Snackbar.make(getActivity().getWindow().getDecorView(), text, BaseTransientBottomBar.LENGTH_LONG).show();
    }

    public void showSnackbar(String text) {
        Snackbar.make(getActivity().getWindow().getDecorView(), text, BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
