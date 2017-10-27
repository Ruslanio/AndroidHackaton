
package com.example.ruslanio.androidhackaton.api.authorization.pojo.cars;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("acceptPersonalDataTreatment")
    @Expose
    private Boolean acceptPersonalDataTreatment;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("birthPlace")
    @Expose
    private String birthPlace;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("cars")
    @Expose
    private List<Car> cars = null;
    @SerializedName("citizenship")
    @Expose
    private String citizenship;
    @SerializedName("drivingExperience")
    @Expose
    private String drivingExperience;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("inn")
    @Expose
    private String inn;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("licenseNumber")
    @Expose
    private String licenseNumber;
    @SerializedName("licenseSerial")
    @Expose
    private String licenseSerial;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("passGettingDate")
    @Expose
    private String passGettingDate;
    @SerializedName("passSeria")
    @Expose
    private String passSeria;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("passwordRecoveryCode")
    @Expose
    private Integer passwordRecoveryCode;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("registrationAdress")
    @Expose
    private String registrationAdress;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("snils")
    @Expose
    private String snils;
    @SerializedName("verificationCode")
    @Expose
    private String verificationCode;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("whoGivedPass")
    @Expose
    private String whoGivedPass;

    public Boolean getAcceptPersonalDataTreatment() {
        return acceptPersonalDataTreatment;
    }

    public void setAcceptPersonalDataTreatment(Boolean acceptPersonalDataTreatment) {
        this.acceptPersonalDataTreatment = acceptPersonalDataTreatment;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassGettingDate() {
        return passGettingDate;
    }

    public void setPassGettingDate(String passGettingDate) {
        this.passGettingDate = passGettingDate;
    }

    public String getPassSeria() {
        return passSeria;
    }

    public void setPassSeria(String passSeria) {
        this.passSeria = passSeria;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPasswordRecoveryCode() {
        return passwordRecoveryCode;
    }

    public void setPasswordRecoveryCode(Integer passwordRecoveryCode) {
        this.passwordRecoveryCode = passwordRecoveryCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistrationAdress() {
        return registrationAdress;
    }

    public void setRegistrationAdress(String registrationAdress) {
        this.registrationAdress = registrationAdress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getWhoGivedPass() {
        return whoGivedPass;
    }

    public void setWhoGivedPass(String whoGivedPass) {
        this.whoGivedPass = whoGivedPass;
    }

}
