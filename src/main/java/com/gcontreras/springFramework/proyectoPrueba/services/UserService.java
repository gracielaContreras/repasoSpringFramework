package com.gcontreras.springFramework.proyectoPrueba.services;

import com.gcontreras.springFramework.proyectoPrueba.models.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private Faker faker;
    private List<User> users = new ArrayList<>();
    @PostConstruct
    public void init(){
        for (int i = 0; i < 100; i++) {
            users.add(new User(faker.funnyName().name(),
                               faker.name().username(),
                               faker.dragonBall().character()));
        }
    }
    public List<User> getUsers(String startWith) {
        if(startWith!= null){
            return users.stream()
                    .filter(user -> user.getUsername().startsWith(startWith))
                    .collect(Collectors.toList());
        }else{
            return users;
        }
    }
    public User getUserByUsername(String username){
      return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException
                                (HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
    }

    public User createUsername(User user){
        if(users.stream().anyMatch(
                u ->u.getUsername().equalsIgnoreCase(user.getUsername()))){
           throw new ResponseStatusException
                    (HttpStatus.CONFLICT, String.format("user %s already exits", user.getUsername()));
        }
        users.add(user);
        return user;
    }
    public User update(User user, String username){
        User userByUpdate = getUserByUsername(username);
        userByUpdate.setNickname(user.getNickname());
        userByUpdate.setPassword(user.getPassword());
        return userByUpdate;
    }
    public void deleteUser(String username){
        User userByUsername = getUserByUsername(username);
        users.remove(userByUsername);
    }
}
