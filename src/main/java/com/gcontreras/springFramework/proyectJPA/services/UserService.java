package com.gcontreras.springFramework.proyectJPA.services;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public Page<User> getUsers(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
    public User getUsersById(Integer userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId)));
    }

    public User getUsersByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));

    }
    public Page<String> getUsername(int page, int size) {
        return repository.findUsername(PageRequest.of(page, size));
    }
    public List<User> getUsernamesStartWith(String startWith){
        List<User> result = repository.findByUsernameStartingWith(startWith);
        if(result.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No se encontró nombre que inicie con %s", startWith));
        }
        return result;
    }
    public Page<User> getUsernamesStartWithPage(String startWith,int page, int size){
        Page<User> result = repository.findByUsernameStartingWith( startWith, PageRequest.of(page, size));
        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No se encontró nombre que inicie con %s", startWith));
        }
        return result;
    }
}
