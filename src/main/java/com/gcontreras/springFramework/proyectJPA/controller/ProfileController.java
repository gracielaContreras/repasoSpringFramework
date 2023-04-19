package com.gcontreras.springFramework.proyectJPA.controller;

import com.gcontreras.springFramework.proyectJPA.entities.Profile;
import com.gcontreras.springFramework.proyectJPA.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/{userId}/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/{profileId}")
    public ResponseEntity<Profile> getById(@PathVariable Integer userId, @PathVariable Integer profileId){
        return new ResponseEntity<> (profileService.getByUserIdAndProfileId(userId, profileId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profile> create(@PathVariable Integer userId, @RequestBody Profile profile){
        return new ResponseEntity<> (profileService.create(userId, profile), HttpStatus.CREATED);
    }
}
