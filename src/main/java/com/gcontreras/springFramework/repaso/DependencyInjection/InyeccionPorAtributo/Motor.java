package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorAtributo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author graciela
 */
@Component
public class Motor {
    @Value("coreano")
    private String modelo;
    @Value("2090")
    private Integer motor;

    public Motor() {}

    public Motor(String modelo, Integer motor) {
        this.modelo = modelo;
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getMotor() {
        return motor;
    }

    public void setMotor(Integer motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "modelo='" + modelo + '\'' +
                ", motor=" + motor +
                '}';
    }
}
