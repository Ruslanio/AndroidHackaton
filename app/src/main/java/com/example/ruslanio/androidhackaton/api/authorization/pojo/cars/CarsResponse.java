
package com.example.ruslanio.androidhackaton.api.authorization.pojo.cars;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarsResponse {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("responseData")
    @Expose
    private List<ResponseDatum> responseData = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ResponseDatum> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ResponseDatum> responseData) {
        this.responseData = responseData;
    }

}
