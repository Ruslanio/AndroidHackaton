package com.example.ruslanio.androidhackaton.fragments;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;
import com.example.ruslanio.androidhackaton.adapters.CarAdapter;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class CarsView extends BaseFragment {

    @BindView(R.id.rv_cars)
    RecyclerView mCarList;

    @BindView(R.id.tv_cars_availability)
    TextView mAvailability;

    private CarAdapter mAdapter;
    private NetworkManager mNetworkManager;
    private SharedPreferences mPreferences;


    @Override
    protected int getLayout() {
        return R.layout.fragment_cars;
    }

    @Override
    protected void onInit() {
        super.onInit();
        mNetworkManager = new NetworkManager();
        mAdapter = new CarAdapter();
        mCarList.setLayoutManager(new LinearLayoutManager(getContext()));
        mCarList.setAdapter(mAdapter);

        mNetworkManager.getCars(getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .map(carsResponse -> carsResponse.getResponseData())
                .subscribe(responseData -> {
                    mAvailability.setVisibility(View.GONE);
                    mAdapter.setCars(responseData);
                    if (responseData.size() == 0)
                        mAvailability.setVisibility(View.VISIBLE);
                    else
                        mAvailability.setVisibility(View.GONE);
                }, error -> {
                    error.printStackTrace();
                    showSnackbar("UNKNOWN ERROR");
                    mAvailability.setVisibility(View.VISIBLE);
                });
    }

    private String getToken(){
        mPreferences = getContext().getSharedPreferences(MAIN_PREF_NAME,MODE_PRIVATE);
        String token = mPreferences.getString(NetworkManager.KEY_TOKEN,"no token");
        return token;
    }

    public static CarsView getInstance(){
        return new CarsView();
    }
}
