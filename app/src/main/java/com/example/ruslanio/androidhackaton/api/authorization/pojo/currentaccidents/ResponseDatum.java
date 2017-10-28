
package com.example.ruslanio.androidhackaton.api.authorization.pojo.currentaccidents;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDatum {

    @SerializedName("carCrashedCount")
    @Expose
    private Integer carCrashedCount;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("finished")
    @Expose
    private Boolean finished;
    @SerializedName("firstCar")
    @Expose
    private FirstCar firstCar;
    @SerializedName("firstUser")
    @Expose
    private FirstUser firstUser;
    @SerializedName("firstUsersName")
    @Expose
    private String firstUsersName;
    @SerializedName("fullDtpPlace")
    @Expose
    private String fullDtpPlace;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("matherialDamagToDifferentThinks")
    @Expose
    private Boolean matherialDamagToDifferentThinks;
    @SerializedName("matherialDamageToTransportExceptAandB")
    @Expose
    private Boolean matherialDamageToTransportExceptAandB;
    @SerializedName("secondCar")
    @Expose
    private SecondCar secondCar;
    @SerializedName("secondUser")
    @Expose
    private SecondUser secondUser;
    @SerializedName("secondUsersName")
    @Expose
    private String secondUsersName;
    @SerializedName("victimsNumbers")
    @Expose
    private Integer victimsNumbers;
    @SerializedName("witnessesFullNameAndAdresses")
    @Expose
    private String witnessesFullNameAndAdresses;

    public Integer getCarCrashedCount() {
        return carCrashedCount;
    }

    public void setCarCrashedCount(Integer carCrashedCount) {
        this.carCrashedCount = carCrashedCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public FirstCar getFirstCar() {
        return firstCar;
    }

    public void setFirstCar(FirstCar firstCar) {
        this.firstCar = firstCar;
    }

    public FirstUser getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(FirstUser firstUser) {
        this.firstUser = firstUser;
    }

    public String getFirstUsersName() {
        return firstUsersName;
    }

    public void setFirstUsersName(String firstUsersName) {
        this.firstUsersName = firstUsersName;
    }

    public String getFullDtpPlace() {
        return fullDtpPlace;
    }

    public void setFullDtpPlace(String fullDtpPlace) {
        this.fullDtpPlace = fullDtpPlace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getMatherialDamagToDifferentThinks() {
        return matherialDamagToDifferentThinks;
    }

    public void setMatherialDamagToDifferentThinks(Boolean matherialDamagToDifferentThinks) {
        this.matherialDamagToDifferentThinks = matherialDamagToDifferentThinks;
    }

    public Boolean getMatherialDamageToTransportExceptAandB() {
        return matherialDamageToTransportExceptAandB;
    }

    public void setMatherialDamageToTransportExceptAandB(Boolean matherialDamageToTransportExceptAandB) {
        this.matherialDamageToTransportExceptAandB = matherialDamageToTransportExceptAandB;
    }

    public SecondCar getSecondCar() {
        return secondCar;
    }

    public void setSecondCar(SecondCar secondCar) {
        this.secondCar = secondCar;
    }

    public SecondUser getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(SecondUser secondUser) {
        this.secondUser = secondUser;
    }

    public String getSecondUsersName() {
        return secondUsersName;
    }

    public void setSecondUsersName(String secondUsersName) {
        this.secondUsersName = secondUsersName;
    }

    public Integer getVictimsNumbers() {
        return victimsNumbers;
    }

    public void setVictimsNumbers(Integer victimsNumbers) {
        this.victimsNumbers = victimsNumbers;
    }

    public String getWitnessesFullNameAndAdresses() {
        return witnessesFullNameAndAdresses;
    }

    public void setWitnessesFullNameAndAdresses(String witnessesFullNameAndAdresses) {
        this.witnessesFullNameAndAdresses = witnessesFullNameAndAdresses;
    }

}
