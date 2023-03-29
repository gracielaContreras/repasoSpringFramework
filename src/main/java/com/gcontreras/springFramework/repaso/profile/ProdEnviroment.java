package com.gcontreras.springFramework.repaso.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdEnviroment implements EnviromentService {
    @Override
    public String getEnviroment() {
        return "prod";
    }
}
