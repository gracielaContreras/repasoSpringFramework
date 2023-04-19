package com.gcontreras.springFramework.proyectJPA.services;

import com.gcontreras.springFramework.proyectJPA.entities.Address;
import com.gcontreras.springFramework.proyectJPA.entities.Profile;
import com.gcontreras.springFramework.proyectJPA.repositories.AddressRepository;
import com.gcontreras.springFramework.proyectJPA.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Address> findAddressByProfileAndUserId(Integer userId, Integer profileId) {
        return addressRepository.findByProfileId(userId, profileId);
    }
    public Address create(Integer userId, Integer profileId, Address address) {
        Optional<Profile> result = profileRepository.findByUserIdAndProfileId(userId, profileId);
        if(result.isPresent()) {
            address.setProfile(result.get());
            return addressRepository.save(address);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Profile %d and user %d not found", profileId, userId));
        }

    }
}
