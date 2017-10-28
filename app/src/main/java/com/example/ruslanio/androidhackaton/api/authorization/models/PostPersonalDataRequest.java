package com.example.ruslanio.androidhackaton.api.authorization.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by VladislavTitov on 28.10.2017.
 */

public class PostPersonalDataRequest {
    @SerializedName("acceptPersonalDataTreatment")
    @Expose
    private Boolean acceptPersonalDataTreatment;
    @SerializedName("birthPlace")
    @Expose
    private String birthPlace;
    @SerializedName("birthday")
    @Expose
    private Date birthday;
    @SerializedName("citizenship")
    @Expose
    private String citizenship;
    @SerializedName("drivingExperience")
    @Expose
    private String drivingExperience;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("inn")
    @Expose
    private String inn;
    @SerializedName("licenseNumber")
    @Expose
    private String licenseNumber;
    @SerializedName("licenseSerial")
    @Expose
    private String licenseSerial;
    @SerializedName("passGettingDate")
    @Expose
    private Date passGettingDate;
    @SerializedName("passNumber")
    @Expose
    private String passNumber;
    @SerializedName("passSeria")
    @Expose
    private String passSeria;
    @SerializedName("registrationAdress")
    @Expose
    private String registrationAdress;
    @SerializedName("snils")
    @Expose
    private String snils;
    @SerializedName("whoGivedPass")
    @Expose
    private String whoGivedPass;

    public Boolean getAcceptPersonalDataTreatment() {
        return acceptPersonalDataTreatment;
    }

    public void setAcceptPersonalDataTreatment(Boolean acceptPersonalDataTreatment) {
        this.acceptPersonalDataTreatment = acceptPersonalDataTreatment;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(String drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseSerial() {
        return licenseSerial;
    }

    public void setLicenseSerial(String licenseSerial) {
        this.licenseSerial = licenseSerial;
    }

    public Date getPassGettingDate() {
        return passGettingDate;
    }

    public void setPassGettingDate(Date passGettingDate) {
        this.passGettingDate = passGettingDate;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public String getPassSeria() {
        return passSeria;
    }

    public void setPassSeria(String passSeria) {
        this.passSeria = passSeria;
    }

    public String getRegistrationAdress() {
        return registrationAdress;
    }

    public void setRegistrationAdress(String registrationAdress) {
        this.registrationAdress = registrationAdress;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getWhoGivedPass() {
        return whoGivedPass;
    }

    public void setWhoGivedPass(String whoGivedPass) {
        this.whoGivedPass = whoGivedPass;
    }
}
