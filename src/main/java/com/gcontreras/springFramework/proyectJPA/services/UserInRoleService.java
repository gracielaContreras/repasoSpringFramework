package com.gcontreras.springFramework.proyectJPA.services;

import com.gcontreras.springFramework.proyectJPA.entities.Role;
import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.entities.UserInRole;
import com.gcontreras.springFramework.proyectJPA.repositories.RoleRepository;
import com.gcontreras.springFramework.proyectJPA.repositories.UserInRoleRepository;
import com.gcontreras.springFramework.proyectJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserInRoleService {
    @Autowired
    private UserInRoleRepository userInRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public UserInRole create(Integer userId, Integer roleId) {
        Optional<User> resultIdUser = userRepository.findById(userId);
        Optional<Role> resultIdRole = roleRepository.findById(roleId);
        UserInRole userInRole = new UserInRole();

        if(! resultIdUser.isPresent()){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, String.format("User %s not found", userId));
        }

        if(! resultIdRole.isPresent()) {
            throw new ResponseStatusException
                        (HttpStatus.NOT_FOUND, String.format("Role %s not found", roleId));
        }

        userInRole.setUser(resultIdUser.get());
        userInRole.setRole(resultIdRole.get());
        return userInRoleRepository.save(userInRole);
    }
    public List<UserInRole> findAll() {
        return userInRoleRepository.findAll();
    }
    public Map<String,List<User>>  findByRoleId(Integer roleId) {
        Map<String, List<User>> result = new HashMap<>();

        Optional<Role> resultIdRole = roleRepository.findById(roleId);
        if(! resultIdRole.isPresent()) {
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND, String.format("Role %s not found", roleId));
        }

        List<User> resultUser = userInRoleRepository.findByRoleId(roleId);
        result.put(resultIdRole.get().getName(), resultUser);

        return result;
    }
}
