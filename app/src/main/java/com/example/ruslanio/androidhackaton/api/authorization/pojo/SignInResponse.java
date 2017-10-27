package com.example.ruslanio.androidhackaton.api.authorization.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by VladislavTitov on 27.10.2017.
 */

public class SignInResponse {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("responseData")
    @Expose
    private String responseData;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }
}
