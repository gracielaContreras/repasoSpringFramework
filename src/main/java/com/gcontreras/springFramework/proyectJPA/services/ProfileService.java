package com.gcontreras.springFramework.proyectJPA.services;

import com.gcontreras.springFramework.proyectJPA.entities.Profile;
import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.repositories.ProfileRepository;
import com.gcontreras.springFramework.proyectJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    public Profile create(Integer userId, Profile profile){
        Optional<User> result = userRepository.findById(userId);
        if(result.isPresent()){
            profile.setUser(result.get());
            return profileRepository.save(profile);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", userId));
        }
    }
    public Profile getByUserIdAndProfileId(Integer userId, Integer profileId) {
        return profileRepository.findByUserIdAndProfileId(userId, profileId)
                .orElseThrow(() ->
                        new ResponseStatusException (HttpStatus.NOT_FOUND,
                                String.format("Profile not found for user %d and profile %d", userId, profileId)));
    }
}
