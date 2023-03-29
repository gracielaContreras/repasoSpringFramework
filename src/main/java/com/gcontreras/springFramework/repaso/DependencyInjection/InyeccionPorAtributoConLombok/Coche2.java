package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorAtributoConLombok;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author graciela
 */
@Component
@Data //incluye @Setter, @Getter
@Builder
public class Coche2 {
    @Value("Hyundai")
    private String nombre;
    @Value("2008")
    private Integer version;
    @Autowired
    private Motor2 motor;

    public Coche2() {
    }

    public Coche2(String nombre, Integer version, Motor2 motor) {
        this.nombre = nombre;
        this.version = version;
        this.motor = motor;
    }
}
