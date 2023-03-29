package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorSetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coche4 {
    private String nombre;
    private Integer version;
    private Motor4 motor;

    public Coche4() {
    }

    public String getNombre() {
        return nombre;
    }
    @Value("Hyundai")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVersion() {
        return version;
    }
    @Value("2008")
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Motor4 getMotor() {
        return motor;
    }
    @Autowired
    public void setMotor(Motor4 motor) {
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
