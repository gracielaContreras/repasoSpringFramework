package com.gcontreras.springFramework.proyectJPA.controller;

import com.gcontreras.springFramework.proyectJPA.entities.Address;
import com.gcontreras.springFramework.proyectJPA.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAddressByProfileAndUserId(
                                @PathVariable Integer userId,
                                @PathVariable Integer profileId){
        return new ResponseEntity<List<Address>>
                (addressService.findAddressByProfileAndUserId(userId, profileId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> create(
            @PathVariable Integer userId,
            @PathVariable Integer profileId,
            @RequestBody Address address){
        return new ResponseEntity<>(addressService.create(userId, profileId, address),HttpStatus.CREATED);
    }
}
