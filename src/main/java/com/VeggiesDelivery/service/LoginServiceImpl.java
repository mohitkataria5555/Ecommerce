package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.Login;
import com.VeggiesDelivery.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepo;

    @Override
    public List<Login> getAllLogins() {
        return (List<Login>) loginRepo.findAll();
    }

    @Override
    public void addLogin(Login login) {
        loginRepo.save(login);
    }
}
