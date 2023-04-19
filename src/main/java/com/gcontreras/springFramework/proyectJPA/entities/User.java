package com.gcontreras.springFramework.proyectJPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable {
//Se implementa una interfaz serializable porque los bean que viajan en un flujo o String deben ser serializable
// para qué se pueda convertir el objeto en un formato que puede ser guardado y transmitido a través de la red o almacenado en disco.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    private static final long serialVersionUID = 3110389822608180777L;

}
