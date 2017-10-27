package com.example.ruslanio.androidhackaton.api.authorization;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class RegistrationBodyRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String password;
    private String phone;

    public RegistrationBodyRequest(String firstName, String lastName, String middleName, String email, String password, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public RegistrationBodyRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
