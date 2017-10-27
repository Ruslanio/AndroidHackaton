
package com.example.ruslanio.androidhackaton.api.authorization.pojo.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("responseData")
    @Expose
    private ResponseData responseData;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

}
