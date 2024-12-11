package com.example.blooddonation.Model;

public class BloodDonationManager extends User {
    private String Role = "Blood Donation Manager";

    public BloodDonationManager(String userID, String name, String email, String password, String phone, String role) {
        super(userID, name, email, password, phone, null, role);
    }

    @Override
    public String getUserID() {
        return super.getUserID();
    }

    @Override
    public void setUserID(String userID) {
        super.setUserID(userID);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }

    @Override
    public String getRole() {
        return super.getRole();
    }
}