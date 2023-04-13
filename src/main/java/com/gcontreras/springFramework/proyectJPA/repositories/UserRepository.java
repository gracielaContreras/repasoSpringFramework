package com.gcontreras.springFramework.proyectJPA.repositories;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Ejemplo de uso de Query Methods (findByUsername)
    Optional<User> findByUsername(String username);
}
