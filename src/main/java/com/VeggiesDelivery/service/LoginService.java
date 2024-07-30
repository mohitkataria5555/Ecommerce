package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.Login;

import java.util.List;

public interface LoginService {

    List<Login> getAllLogins();
    void addLogin(Login login);
}
