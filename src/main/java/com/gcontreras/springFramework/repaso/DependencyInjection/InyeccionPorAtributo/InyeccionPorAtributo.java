package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorAtributo;

import com.gcontreras.springFramework.repaso.RepasoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author graciela
 */
@SpringBootApplication
public class InyeccionPorAtributo {
        public static void main(String[] args) {

            ConfigurableApplicationContext context = SpringApplication.run(RepasoApplication.class, args);
            Coche coche = context.getBean(Coche.class);
            System.out.println(coche);
    }

}
