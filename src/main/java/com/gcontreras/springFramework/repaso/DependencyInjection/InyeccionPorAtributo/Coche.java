package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorAtributo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author graciela
 */
@Component
public class Coche {
    @Value("Hyundai")
    private String nombre;
    @Value("2008")
    private Integer version;
    @Autowired
    private Motor motor;

    public Coche() {
    }

    public Coche(String nombre, Integer version, Motor motor) {
        this.nombre = nombre;
        this.version = version;
        this.motor = motor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "nombre='" + nombre + '\'' +
                ", version=" + version +
                ", motor=" + motor +
                '}';
    }
}
