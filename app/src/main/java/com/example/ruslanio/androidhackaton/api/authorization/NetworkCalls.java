package com.example.ruslanio.androidhackaton.api.authorization;

import com.example.ruslanio.androidhackaton.api.authorization.models.IssueRoadAccident;
import com.example.ruslanio.androidhackaton.api.authorization.models.PostCarRequest;
import com.example.ruslanio.androidhackaton.api.authorization.models.PostPersonalDataRequest;
import com.example.ruslanio.androidhackaton.api.authorization.models.RegistrationBodyRequest;
import com.example.ruslanio.androidhackaton.api.authorization.models.SignInRequest;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.RegistrationResponse;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.Response;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.SignInResponse;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.cars.CarsResponse;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.user.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public interface NetworkCalls {

    @POST("/v1/sign_up")
    Observable<RegistrationResponse> register(@Body RegistrationBodyRequest registrationBodyRequest);

    @POST("/v1/sign_in")
    Observable<SignInResponse> signIn(@Body SignInRequest request);

    @POST("/secure/v1/user/data")
    Observable<Response> addPersonal(@Header("Authorization") String token, @Body PostPersonalDataRequest request);

    @POST("/secure/v1/user/cars")
    Observable<Response> addCar(@Header("Authorization") String token, @Body PostCarRequest request);

    @POST("/secure/v1/dtp")
    Observable<Response> addDtp(@Header("Authorization") String token, @Body IssueRoadAccident request);

    @GET("/secure/v1/user/cars")
    Observable<CarsResponse> getCars(@Header("Authorization") String token);

    @GET("/secure/v1/user")
    Observable<UserResponse> getUser(@Header("Authorization") String token);
}
