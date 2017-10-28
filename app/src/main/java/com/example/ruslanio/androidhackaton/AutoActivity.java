package com.example.ruslanio.androidhackaton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.api.authorization.models.PostCarRequest;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class AutoActivity extends BaseActivity {

    private SharedPreferences preferences;

    @BindView(R.id.save_car)
    Button btnSaveCar;

    @Override
    protected void onInit() {
        preferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);

        if (preferences.getBoolean(IS_AUTO, false)) {
            goToMain();
        }

        btnSaveCar.setOnClickListener(v -> {
            NetworkManager manager = new NetworkManager();
            manager.addCar(preferences.getString(NetworkManager.KEY_TOKEN, ""), getData())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.getError() != null){
                            showSnackbar(response.getError());
                        } else {
                            setIsAuto();
                            goToMain();
                        }
                    }, Throwable::printStackTrace);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_auto;
    }

    public PostCarRequest getData() {
        return new PostCarRequest(); //
    }

    private void setIsAuto() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_AUTO, true);
        editor.commit();
    }

    private void goToMain() {
        Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goToMain);
        finish();
    }
}
