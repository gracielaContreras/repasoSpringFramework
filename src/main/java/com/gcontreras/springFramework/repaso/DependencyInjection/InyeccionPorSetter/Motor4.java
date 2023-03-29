package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorSetter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Motor4 {
    private String modelo;
    private Integer motor;

    public Motor4() {
    }

    public String getModelo() {
        return modelo;
    }
    @Value("coreano")
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getMotor() {
        return motor;
    }
    @Value("2090")
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
