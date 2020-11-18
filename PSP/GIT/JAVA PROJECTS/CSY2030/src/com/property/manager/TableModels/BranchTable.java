package com.property.manager.TableModels;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class BranchTable implements Serializable {

    private  SimpleStringProperty name;
    private  SimpleStringProperty address;
    private  SimpleStringProperty phoneNumber;
    private  SimpleStringProperty email;
    private  SimpleStringProperty webAddress;
    private  SimpleStringProperty userName;
    private  SimpleStringProperty password;

    public BranchTable(String name, String address, String phoneNumber, String email, String webAddress, String userName,
                       String password) {
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.webAddress = new SimpleStringProperty(webAddress);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getWebAddress() {
        return webAddress.get();
    }

    public void setWebAddress(String webAddress) {
        this.webAddress.set(webAddress);
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password .set(password);
    }
}
