package com.gcontreras.springFramework.proyectJPA.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerBeanConfig {
    //Definición de forma explícita para poder crear el bean
    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
