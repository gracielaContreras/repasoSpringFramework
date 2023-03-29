package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Motor3 {
    private String modelo;
    private Integer motor;

    public Motor3(@Value("coreano") String modelo,@Value("2090") Integer motor) {
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
