package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorAtributoConLombok;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author graciela
 */
@Component
@Data  //incluye @Setter, @Getter
@Builder
public class Motor2 {
    @Value("coreano")
    private String modelo;
    @Value("2090")
    private Integer motor;

    public Motor2() {}

    public Motor2(String modelo, Integer motor) {
        this.modelo = modelo;
        this.motor = motor;
    }
}
