package com.gcontreras.springFramework.repaso.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
//@Scope("prototype") // Recordar que predestroy no se ejecuta para beans de tipo prototype
//Los bean Singleton son por default eager, Los bean prototype son por default lazy.
@Lazy //Si el bean es lazy no se inicializara a menos que se inyecte
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
    private static Logger log= LoggerFactory.getLogger(LifeCycleBean.class);

    /**
     * Se ejecuta durante la construcción del bean "BeanNameAware
     */
    public void setBeanName(String name){
        log.info("Bean name aware {} ", name);
    }
    /**
     * Se ejecutará después de la inyección de dependencias
     */
    @PostConstruct
    public void init(){
        log.info("Post construct");
    }
    /**
     * Se ejecutará antes de que el bean sea destruido
     * No se ejecutara para beans prototype
     * Solo se ejecutara durante una terminación del VM de forma normal
     */
    @PreDestroy
    public void destroyBean(){
        log.info("Pre destroy");
    }

    /**
     * Los métodos destroy() y afterPropertiesSet() son parte de InitializingBean, DisposableBean
     */
    @Override
    public void destroy() throws Exception {
        log.info("Destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("After properties set method");
    }
}
