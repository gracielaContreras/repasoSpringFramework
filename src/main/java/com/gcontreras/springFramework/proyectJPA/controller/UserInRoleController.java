package com.gcontreras.springFramework.proyectJPA.controller;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.entities.UserInRole;
import com.gcontreras.springFramework.proyectJPA.services.UserInRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/assign")
public class UserInRoleController {
    @Autowired
    private UserInRoleService userInRoleService;

    @PostMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<UserInRole> create(@PathVariable Integer userId, @PathVariable Integer roleId){
        return new ResponseEntity<> (userInRoleService.create(userId, roleId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserInRole>> findAllRoles(){
        return new ResponseEntity<> (userInRoleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/role/{roleId}/users")
    public ResponseEntity<Map<String,List<User>>> findByUserIdAndRoleId(@PathVariable Integer roleId){
        return new ResponseEntity<> (userInRoleService.findByRoleId(roleId), HttpStatus.OK);
    }
}
