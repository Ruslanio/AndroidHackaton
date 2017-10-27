
package com.example.ruslanio.androidhackaton.api.authorization.pojo.cars;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDatum {

    @SerializedName("carMark")
    @Expose
    private String carMark;
    @SerializedName("carModel")
    @Expose
    private String carModel;
    @SerializedName("carNumber")
    @Expose
    private String carNumber;
    @SerializedName("carYearOfBuilding")
    @Expose
    private String carYearOfBuilding;
    @SerializedName("horsePower")
    @Expose
    private Integer horsePower;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("insurancePolicyNumber")
    @Expose
    private String insurancePolicyNumber;
    @SerializedName("insurancePolicySerial")
    @Expose
    private String insurancePolicySerial;
    @SerializedName("ptsNumber")
    @Expose
    private String ptsNumber;
    @SerializedName("ptsSerialNumber")
    @Expose
    private String ptsSerialNumber;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("vinNumber")
    @Expose
    private String vinNumber;
    @SerializedName("whoGivedPts")
    @Expose
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
