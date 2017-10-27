package com.example.ruslanio.androidhackaton.api.authorization;

import com.example.ruslanio.androidhackaton.api.authorization.pojo.RegistrationResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public interface CallRegistration {

    @POST("/v1/sign_up")
    Observable<RegistrationResponse> register(@Body RegistrationBodyRequest registrationBodyRequest);
}
