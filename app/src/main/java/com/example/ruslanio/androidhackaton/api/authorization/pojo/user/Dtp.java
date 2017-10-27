
package com.example.ruslanio.androidhackaton.api.authorization.pojo.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dtp {

    @SerializedName("carCrashedCount")
    @Expose
    private Integer carCrashedCount;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("finished")
    @Expose
    private Boolean finished;
    @SerializedName("fullDtpPlace")
    @Expose
    private String fullDtpPlace;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("matherialDamagToDifferentThinks")
    @Expose
    private Boolean matherialDamagToDifferentThinks;
    @SerializedName("matherialDamageToTransportExceptAandB")
    @Expose
    private Boolean matherialDamageToTransportExceptAandB;
    @SerializedName("user")
    @Expose
    private User_ user;
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

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
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
