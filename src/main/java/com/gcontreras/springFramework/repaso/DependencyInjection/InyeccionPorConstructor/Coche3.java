package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coche3 {
    private String nombre;
    private Integer version;
    private Motor3 motor;

    @Autowired
    public Coche3(@Value("Hyundai")String nombre,@Value("2008") Integer version, Motor3 motor) {
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

    public Motor3 getMotor() {
        return motor;
    }

    public void setMotor(Motor3 motor) {
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
