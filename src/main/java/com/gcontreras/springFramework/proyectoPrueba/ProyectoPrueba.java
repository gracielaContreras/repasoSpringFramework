package com.gcontreras.springFramework.proyectoPrueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//Es una Meta anotación, ya que contiene anotaciones como:
// @EnableAutoConfiguration,@ComponentScan y @Configuration
public class ProyectoPrueba {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoPrueba.class, args);
    }
}
