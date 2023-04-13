package com.gcontreras.springFramework.proyectJPA.controller;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
//    @GetMapping
//    public ResponseEntity<Page<User>> getUsers(
//            @RequestParam(name = "page", required = false) int page,
//            @RequestParam(name = "size", required = false) int size){
//        return new ResponseEntity<>(userService.getUsers(page,size),HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity<Page<User>> getUsers(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page, //con defaultValue asignas un valor por defecto
            @RequestParam(name = "size", required = false, defaultValue = "1000") int size){
        return new ResponseEntity<>(userService.getUsers(page,size),HttpStatus.OK);
    }

    @GetMapping("/usernames")
    public ResponseEntity<Page<String>> getUsername(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page, //con defaultValue asignas un valor por defecto
            @RequestParam(name = "size", required = false, defaultValue = "1000") int size) {
        return new ResponseEntity<>(userService.getUsername(page, size), HttpStatus.OK);
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<User>> getUsernameByLetra(
                    @RequestParam(value = "startWith", required = false) String startWith) {
        return new ResponseEntity<>(userService.getUsernamesStartWith(startWith), HttpStatus.OK);
    }
    @GetMapping("/buscarConPaginacion")
    public ResponseEntity<Page<User>> getUsernameByLetraPage(
            @RequestParam(value = "startWith", required = false) String startWith,
            @RequestParam(name = "page", required = false) int page, //con defaultValue asignas un valor por defecto
            @RequestParam(name = "size", required = false) int size) {
        return new ResponseEntity<>(userService.getUsernamesStartWithPage(startWith,page,size), HttpStatus.OK);
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
