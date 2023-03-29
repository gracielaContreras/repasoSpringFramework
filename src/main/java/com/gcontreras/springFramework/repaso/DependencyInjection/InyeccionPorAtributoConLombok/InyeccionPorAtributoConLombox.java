package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorAtributoConLombok;

import com.gcontreras.springFramework.repaso.RepasoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InyeccionPorAtributoConLombox {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RepasoApplication.class, args);
        Coche2 coche = context.getBean(Coche2.class);
        System.out.println(coche);
    }
}
