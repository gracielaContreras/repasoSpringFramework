package com.gcontreras.springFramework.repaso.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure{
    //En caso de que no encuentre la propiedad (circle.radius) va a asignar un valor por defecto. En este caso es: 1
    @Value("${circle.radius:1}")
    private double radio;
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}
