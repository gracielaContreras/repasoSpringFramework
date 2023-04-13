package com.gcontreras.springFramework.proyectJPA;

import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Es una Meta anotación, ya que contiene anotaciones como:
// @EnableAutoConfiguration,@ComponentScan y @Configuration
public class ProyectoJPA implements ApplicationRunner {
    @Autowired
    private Faker faker;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProyectoJPA.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 20000; i++) {
            User user = new User();
            user.setPassword(faker.dragonBall().character());
            user.setProfile(null);
            user.setUsername(faker.name().username());
            userRepository.save(user);
        }
    }
}
