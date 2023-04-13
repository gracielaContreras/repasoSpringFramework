package com.gcontreras.springFramework.proyectJPA.repositories;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Ejemplo de uso de Query Methods (findByUsername)
    Optional<User> findByUsername(String username);

    /**
     * Esto NO es SQL se llama JPQL (Java Persistence Query Language)
     * Son Queries personalizadas
     */
    @Query("SELECT u.username FROM User u")
    Page<String> findUsername(Pageable pageable);

    /**
     * Se utiliza los métodos proporcionados por el framework de Spring Data JPA
     * para ejecutar consultas JPQL con la cláusula LIKE
     */
    List<User> findByUsernameStartingWith(String startWith);
    Page<User> findByUsernameStartingWith(String startWith, Pageable pageable);
}
