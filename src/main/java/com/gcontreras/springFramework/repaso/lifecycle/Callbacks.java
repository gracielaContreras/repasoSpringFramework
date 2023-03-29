package com.gcontreras.springFramework.repaso.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Callbacks {
    private static Logger log = LoggerFactory.getLogger(Callbacks.class);
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ExplicitBean getBean(){
        return new ExplicitBean();
    }
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Callbacks.class, args);
        LifeCycleBean bean = context.getBean(LifeCycleBean.class);
    }
}
