package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.AdminLogin;

import java.util.List;

public interface AdminService {

    List<AdminLogin> getAllAdmin();

    void addAdmin(AdminLogin admin);

}
