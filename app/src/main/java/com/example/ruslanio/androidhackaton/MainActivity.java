package com.example.ruslanio.androidhackaton;

import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.fragments.CarsView;
import com.example.ruslanio.androidhackaton.fragments.HomeView;
import com.example.ruslanio.androidhackaton.fragments.MapView;
import com.example.ruslanio.androidhackaton.fragments.NoteView;
import com.example.ruslanio.androidhackaton.fragments.PersonalView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements OnTabSelectListener {

    private static final String TAG_MAP = "tag_map";
    private static final String TAG_HOME = "tag_home";
    private static final String TAG_CARS = "tag_cars";
    private static final String TAG_PERSONAL = "tag_personal";
    private static final String TAG_NOTE = "tag_note";

    private SharedPreferences mPreferences;

    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    @Override
    protected void onInit() {
        mBottomBar.setOnTabSelectListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private String getToken(){
        mPreferences = getSharedPreferences(MAIN_PREF_NAME,MODE_PRIVATE);
        String token = mPreferences.getString(NetworkManager.KEY_TOKEN,"no token");
        return token;
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId){
            case R.id.tab_home:
                showHome();
                break;
            case R.id.tab_cars:
                showCars();
                break;
            case R.id.tab_map:
                showMap();
                break;
            case R.id.tab_personal:
                showPersonal();
                break;
            case R.id.tab_note:
                showNote();
                break;
        }
    }

    private void showNote() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment note = fragmentManager.findFragmentByTag(TAG_NOTE);
        if (note == null)
            note = NoteView.getInstance();
        if (!note.isAdded())
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container_main,note,TAG_NOTE)
                    .commit();

    }

    private void showMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment map = fragmentManager.findFragmentByTag(TAG_MAP);
        if (map == null)
            map = MapView.getInstance();
        if (!map.isAdded())
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container_main,map,TAG_MAP)
                    .commit();

    }

    private void showPersonal() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment personal = fragmentManager.findFragmentByTag(TAG_PERSONAL);
        if (personal == null)
            personal = PersonalView.getInstance();
        if (!personal.isAdded())
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container_main,personal,TAG_PERSONAL)
                    .commit();

    }

    private void showCars() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment cars = fragmentManager.findFragmentByTag(TAG_CARS);
        if (cars == null)
            cars = CarsView.getInstance();
        if (!cars.isAdded())
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container_main,cars,TAG_CARS)
                    .commit();

    }

    private void showHome() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment home = fragmentManager.findFragmentByTag(TAG_HOME);
        if (home == null)
            home = HomeView.getInstance();
        if (!home.isAdded())
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container_main,home,TAG_HOME)
                    .commit();

    }
}
