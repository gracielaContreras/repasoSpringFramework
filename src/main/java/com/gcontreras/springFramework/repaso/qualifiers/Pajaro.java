package com.gcontreras.springFramework.repaso.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Pajaro extends Animal implements Voladores {
    private static Logger logger = LoggerFactory.getLogger(Pajaro.class);

    public Pajaro(@Value("Picaflor") String nombre, @Value("1") Integer edad) {
        super(nombre, edad);
    }
    @Override
    public void volar() {
        logger.info("Soy un pájaro y puedo volar");
    }
}
