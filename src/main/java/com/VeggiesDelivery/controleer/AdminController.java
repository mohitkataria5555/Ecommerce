package com.VeggiesDelivery.controleer;


import com.VeggiesDelivery.entity.AdminLogin;
import com.VeggiesDelivery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController() {
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<AdminLogin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PostMapping("/admin/add")
        public ResponseEntity<String> addAdmin(@RequestBody AdminLogin admin){
        adminService.addAdmin(admin);
        return  new ResponseEntity<>("Admin is Added", HttpStatus.OK);
    }

}
