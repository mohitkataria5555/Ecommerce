package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.UserSignUp;
import com.VeggiesDelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserSignUp> getAllUsers() {
        return (List<UserSignUp>) userRepo.findAll();
    }

    @Override
    public void addUser(UserSignUp user) {
        userRepo.save(user);

    }


    @Override
    public void updateUser(String email, UserSignUp user) {
        userRepo.save(user);
    }
}
