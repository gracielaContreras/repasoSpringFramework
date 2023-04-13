package com.gcontreras.springFramework.proyectJPA.controller;

import com.gcontreras.springFramework.proyectJPA.entities.Role;
import com.gcontreras.springFramework.proyectJPA.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping
    public ResponseEntity<List<Role>> getList(){
        return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role){
        return new ResponseEntity<>(service.create(role), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable Integer id, @RequestBody Role role){
        return new ResponseEntity<>(service.update(id, role), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
