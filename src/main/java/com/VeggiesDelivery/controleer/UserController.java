package com.VeggiesDelivery.controleer;

import com.VeggiesDelivery.entity.UserSignUp;
import com.VeggiesDelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserSignUp> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user/add")
    public ResponseEntity<String> addUser(@RequestBody UserSignUp user){
        userService.addUser(user);
        return new ResponseEntity<String>("User added to DB", HttpStatus.OK);
    }
}
