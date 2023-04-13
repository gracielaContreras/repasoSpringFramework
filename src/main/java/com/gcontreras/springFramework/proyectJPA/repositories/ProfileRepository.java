package com.gcontreras.springFramework.proyectJPA.repositories;

import com.gcontreras.springFramework.proyectJPA.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
