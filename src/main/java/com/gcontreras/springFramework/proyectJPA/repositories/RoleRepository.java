package com.gcontreras.springFramework.proyectJPA.repositories;

import com.gcontreras.springFramework.proyectJPA.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
