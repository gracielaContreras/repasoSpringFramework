package com.gcontreras.springFramework.proyectJPA.repositories;

import com.gcontreras.springFramework.proyectJPA.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
    @Query("SELECT p FROM Profile p WHERE p.user.id = ?1 AND p.id = ?2")
    Optional<Profile> findByUserIdAndProfileId(Integer userId, Integer profileId);
}
