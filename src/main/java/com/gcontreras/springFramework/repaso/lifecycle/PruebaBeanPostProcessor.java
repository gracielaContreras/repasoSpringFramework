package com.gcontreras.springFramework.repaso.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor
 * Se puede realizar acciones antes de ejecutar el bean y después de inicializar el bean
 * se conoce que bean se construyeron
 */
//@Component
public class PruebaBeanPostProcessor implements BeanPostProcessor {
    private static Logger log = LoggerFactory.getLogger(PruebaBeanPostProcessor.class);

    /**
     * postProcessBeforeInitialization
     * Permite ejecutar una lógica de inicialización antes de que se inicialice el bean
     * por el contenedor de spring
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Before Initialization {} ", beanName);
        return bean;
    }

    /**
     * postProcessAfterInitialization
     * Permite ejecutar una lógica de inicialización después de que se inicialice el bean
     * por el contenedor de spring
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("After Initialization {} ", beanName);
        return bean;
    }
}
