package com.example.ruslanio.androidhackaton.api.authorization.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {

    @SerializedName("responseData")
    @Expose
    private String responseData;
    @SerializedName("error")
    @Expose
    private Object error;

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

}
