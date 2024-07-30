package com.VeggiesDelivery.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class UserSignUp {

    @Id
    private String email;
    private String fullName;
    private long mobileNo;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Login login;


    public UserSignUp() {
    }

    public UserSignUp(String email, String fullName, long mobileNo, String password, Login login) {
        this.email = email;
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.password = password;
        this.login = login;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }


    @Override
    public String toString() {
        return "UserSignUp{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobileNo=" + mobileNo +
                ", password='" + password + '\'' +
                ", login=" + login +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUp that)) return false;
        return getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
