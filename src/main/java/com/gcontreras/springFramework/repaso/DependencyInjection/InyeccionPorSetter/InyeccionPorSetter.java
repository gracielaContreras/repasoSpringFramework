package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorSetter;

import com.gcontreras.springFramework.repaso.RepasoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class InyeccionPorSetter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RepasoApplication.class, args);
        Coche4 coche = context.getBean(Coche4.class);
        System.out.println(coche);
    }
}
