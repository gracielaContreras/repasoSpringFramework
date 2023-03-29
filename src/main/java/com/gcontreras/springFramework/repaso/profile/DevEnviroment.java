package com.gcontreras.springFramework.repaso.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default"}) //default, se activa cuando no se especifica el ambiente a utilizar
public class DevEnviroment implements EnviromentService {
    @Override
    public String getEnviroment() {
        return "dev";
    }
}
