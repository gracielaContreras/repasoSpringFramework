package com.gcontreras.springFramework.repaso.DependencyInjection.InyeccionPorConstructor;

import com.gcontreras.springFramework.repaso.RepasoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author graciela
 */
@SpringBootApplication
public class InyeccionPorConstructor {
        public static void main(String[] args) {

            ConfigurableApplicationContext context = SpringApplication.run(RepasoApplication.class, args);
            Coche3 coche = context.getBean(Coche3.class);
            System.out.println(coche);
    }

}
