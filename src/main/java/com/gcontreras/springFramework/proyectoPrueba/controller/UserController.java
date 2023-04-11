package com.gcontreras.springFramework.proyectoPrueba.controller;

import com.gcontreras.springFramework.proyectoPrueba.models.User;
import com.gcontreras.springFramework.proyectoPrueba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//Definición de mi recurso
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    //Método HTTP + Recurso -> Handler method
    public ResponseEntity<List<User>>get(@RequestParam(value = "startWith", required = false) String startWith){
       return new ResponseEntity<>(userService.getUsers(startWith), HttpStatus.OK);
    }

    /**
     * Path params o "@PathVariable"
     * /users/g.contreras/emails/10
     * Dame el email con ID 10 de g.contreras
     * se utiliza cuando se espera solo un resultado
     *
     * Query params o "@RequestParam"
     * /users/g.contreras/emails?startDate=11-04-2023&endDate=12-04-2023
     * se utiliza cuando se espera tener multiples resultados
     */
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.createUsername(user), HttpStatus.CREATED);
    }
    @PutMapping("/{username}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable String username){
        return new ResponseEntity<>(userService.update(user,username), HttpStatus.OK);
    }
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> delete(@PathVariable String username){
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
