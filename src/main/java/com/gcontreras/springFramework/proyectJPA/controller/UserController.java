package com.gcontreras.springFramework.proyectJPA.controller;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUsersById(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getUsersById(userId),HttpStatus.OK);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUsersById(@PathVariable String username){
        return new ResponseEntity<>(userService.getUsersByUsername(username),HttpStatus.OK);
    }
}
