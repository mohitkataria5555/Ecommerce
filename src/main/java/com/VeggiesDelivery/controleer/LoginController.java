package com.VeggiesDelivery.controleer;

import com.VeggiesDelivery.entity.Login;
import com.VeggiesDelivery.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginService loginSer;

    @GetMapping("/logins")
    public List<Login> getAllLogins(){
        return loginSer.getAllLogins();
    }

    @PostMapping("/login/add")
    public ResponseEntity<String> addLogin(@RequestBody Login login){
        loginSer.addLogin(login);
        return new ResponseEntity<String>("User added", HttpStatus.OK);
    }
}
