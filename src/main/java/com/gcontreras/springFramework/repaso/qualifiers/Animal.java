package com.gcontreras.springFramework.repaso.qualifiers;
import lombok.Data;
@Data
public abstract class Animal {
    private String nombre;
    private Integer edad;
    public Animal(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
