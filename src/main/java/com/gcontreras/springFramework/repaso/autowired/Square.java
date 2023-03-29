package com.gcontreras.springFramework.repaso.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {
    @Value("${square.side}")
    private double side;
    @Override
    public double calcularArea() {
        return side*side;
    }
}
