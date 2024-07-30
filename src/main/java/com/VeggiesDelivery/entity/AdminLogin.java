package com.VeggiesDelivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class AdminLogin {

    @Id
    private long mobileNo;
    private String email;
    private String password;
    private String loginStatus;

    public AdminLogin() {
    }

    public AdminLogin(long mobileNo, String email, String password, String loginStatus) {
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "AdminLogin{" +
                "mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminLogin that = (AdminLogin) o;
        return mobileNo == that.mobileNo && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNo, email);
    }
}
