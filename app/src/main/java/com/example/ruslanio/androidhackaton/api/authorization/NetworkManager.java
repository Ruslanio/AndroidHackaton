package com.example.ruslanio.androidhackaton.api.authorization;

import com.example.ruslanio.androidhackaton.api.authorization.models.RegistrationBodyRequest;
import com.example.ruslanio.androidhackaton.api.authorization.models.SignInRequest;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.RegistrationResponse;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.SignInResponse;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.cars.CarsResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class NetworkManager {
    public static final String KEY_TOKEN = "key_token";
    private static final String BASE_URL = "https://dtp-hack.herokuapp.com";
    private final NetworkCalls mNetworkCalls;


    public NetworkManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.MINUTES)
                .readTimeout(8, TimeUnit.MINUTES)
                .writeTimeout(8, TimeUnit.MINUTES)
                .connectionPool(new ConnectionPool(1, 5, TimeUnit.MINUTES))
                .build();
        mNetworkCalls = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .baseUrl(BASE_URL)
                .build()
                .create(NetworkCalls.class);
    }

    public Observable<RegistrationResponse> register(RegistrationBodyRequest registrationBodyRequest){
        return mNetworkCalls.register(registrationBodyRequest);
    }

    public Observable<SignInResponse> signIn(SignInRequest request) {
        return mNetworkCalls.signIn(request);
    }

    public Observable<CarsResponse> getCars(String token){
        return mNetworkCalls.getCars(token);
    }
}