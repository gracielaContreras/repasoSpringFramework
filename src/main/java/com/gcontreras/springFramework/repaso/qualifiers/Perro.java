package com.gcontreras.springFramework.repaso.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Perro extends Animal{

    public Perro(@Value("Tomy")String nombre, @Value("1") Integer edad) {
        super(nombre, edad);
    }
}
