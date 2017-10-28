package com.example.ruslanio.androidhackaton.api.authorization.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by VladislavTitov on 28.10.2017.
 */

public class PostCarRequest {

    private String carMark;

    private String carModel;

    private String carNumber;

    private String carYearOfBuilding;

    private Integer horsePower;

    private String insurancePolicyNumber;

    private String insurancePolicySerial;

    private String ptsNumber;

    private String ptsSerialNumber;

    private String vinNumber;

    private String whoGivedPts;

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarYearOfBuilding() {
        return carYearOfBuilding;
    }

    public void setCarYearOfBuilding(String carYearOfBuilding) {
        this.carYearOfBuilding = carYearOfBuilding;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getInsurancePolicySerial() {
        return insurancePolicySerial;
    }

    public void setInsurancePolicySerial(String insurancePolicySerial) {
        this.insurancePolicySerial = insurancePolicySerial;
    }

    public String getPtsNumber() {
        return ptsNumber;
    }

    public void setPtsNumber(String ptsNumber) {
        this.ptsNumber = ptsNumber;
    }

    public String getPtsSerialNumber() {
        return ptsSerialNumber;
    }

    public void setPtsSerialNumber(String ptsSerialNumber) {
        this.ptsSerialNumber = ptsSerialNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getWhoGivedPts() {
        return whoGivedPts;
    }

    public void setWhoGivedPts(String whoGivedPts) {
        this.whoGivedPts = whoGivedPts;
    }

}
