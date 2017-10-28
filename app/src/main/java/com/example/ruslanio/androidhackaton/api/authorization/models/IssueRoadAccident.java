package com.example.ruslanio.androidhackaton.api.authorization.models;

/**
 * Created by Ruslanio on 28.10.2017.
 */

public class IssueRoadAccident {
    private String secondRegNumber;

    private String mSecondPhone;

    private boolean mDamageToThings;

    private boolean mDamageToVehicles;

    private String mDtpAddress;

    private String mVictims;

    private String mWitnessName;

    private String mWitnessAddress;

    private String mFirstReg;

    private String mFirstPhone;

    public String getFirstReg() {
        return mFirstReg;
    }

    public void setFirstReg(String firstReg) {
        mFirstReg = firstReg;
    }

    public String getFirstPhone() {
        return mFirstPhone;
    }

    public void setFirstPhone(String firstPhone) {
        mFirstPhone = firstPhone;
    }

    public String getSecondRegNumber() {
        return secondRegNumber;
    }

    public void setSecondRegNumber(String secondRegNumber) {
        this.secondRegNumber = secondRegNumber;
    }

    public String getSecondPhone() {
        return mSecondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        mSecondPhone = secondPhone;
    }

    public boolean isDamageToThings() {
        return mDamageToThings;
    }

    public void setDamageToThings(boolean damageToThings) {
        mDamageToThings = damageToThings;
    }

    public boolean isDamageToVehicles() {
        return mDamageToVehicles;
    }

    public void setDamageToVehicles(boolean damageToVehicles) {
        mDamageToVehicles = damageToVehicles;
    }

    public String getDtpAddress() {
        return mDtpAddress;
    }

    public void setDtpAddress(String dtpAddress) {
        mDtpAddress = dtpAddress;
    }

    public String getVictims() {
        return mVictims;
    }

    public void setVictims(String victims) {
        mVictims = victims;
    }

    public String getWitnessName() {
        return mWitnessName;
    }

    public void setWitnessName(String witnessName) {
        mWitnessName = witnessName;
    }

    public String getWitnessAddress() {
        return mWitnessAddress;
    }

    public void setWitnessAddress(String witnessAddress) {
        mWitnessAddress = witnessAddress;
    }
}
