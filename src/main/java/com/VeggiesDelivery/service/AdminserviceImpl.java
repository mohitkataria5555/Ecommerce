package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.AdminLogin;
import com.VeggiesDelivery.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminserviceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepo;
    @Override
    public List<AdminLogin> getAllAdmin() {
        return (List<AdminLogin>) adminRepo.findAll();
    }

    @Override
    public void addAdmin(AdminLogin admin) {
        adminRepo.save(admin);
    }
}
