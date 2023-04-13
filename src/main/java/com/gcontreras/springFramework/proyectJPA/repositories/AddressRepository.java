package com.gcontreras.springFramework.proyectJPA.repositories;

import com.gcontreras.springFramework.proyectJPA.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
