package com.gcontreras.springFramework.proyectJPA;

import com.gcontreras.springFramework.proyectJPA.entities.Role;
import com.gcontreras.springFramework.proyectJPA.entities.User;
import com.gcontreras.springFramework.proyectJPA.entities.UserInRole;
import com.gcontreras.springFramework.proyectJPA.repositories.RoleRepository;
import com.gcontreras.springFramework.proyectJPA.repositories.UserInRoleRepository;
import com.gcontreras.springFramework.proyectJPA.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Random;

@SpringBootApplication
//Es una Meta anotación, ya que contiene anotaciones como:
// @EnableAutoConfiguration,@ComponentScan y @Configuration
public class ProyectoJPA implements ApplicationRunner {
    @Autowired
    private Faker faker;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserInRoleRepository userInRoleRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProyectoJPA.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role[] = { new Role("ADMIN"), new Role("USER"), new Role("SUPPORT") };

        for(Role rol : role){
            roleRepository.save(rol);
        }

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setPassword(faker.dragonBall().character());
            user.setUsername(faker.name().username());
            User userSave = userRepository.save(user);

            UserInRole userInRole = new UserInRole(userSave, role[new Random().nextInt(3)]);
            userInRoleRepository.save(userInRole);
        }
    }
}
