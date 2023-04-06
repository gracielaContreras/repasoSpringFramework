package com.gcontreras.springFramework.repaso.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Modifier;
@Component
@Aspect
@Order(1)
public class MyAspect2 {
    private static final Logger log = LoggerFactory.getLogger(MyAspect2.class);

    @Before("PointcutExample.targetOjectMethods()")
    public void before(JoinPoint joinPoint){
        log.info("1. Method name: {} ", joinPoint.getSignature().getName() );
        log.info("1. Object type: {} ", joinPoint.getSignature().getDeclaringType() );
        log.info("1. Is public: {} ", Modifier.isPublic(joinPoint.getSignature().getModifiers()));
        log.info("1. Arguments: {} ", joinPoint.getArgs());
        log.info("1. Before advice");
    }
}
