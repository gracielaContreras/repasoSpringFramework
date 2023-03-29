package com.gcontreras.springFramework.repaso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:areas.properties")
public class FigurePropertyConfiguration {

    @Bean  //Declaración de beans de forma explicita
    public PropertySourcesPlaceholderConfigurer getPropertiesConfig(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
