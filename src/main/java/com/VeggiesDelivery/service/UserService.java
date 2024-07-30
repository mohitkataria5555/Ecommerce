package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.UserSignUp;

import java.util.List;

public interface UserService {

    List<UserSignUp> getAllUsers();
    void addUser(UserSignUp user);
    void updateUser(String email, UserSignUp user);

  
}
