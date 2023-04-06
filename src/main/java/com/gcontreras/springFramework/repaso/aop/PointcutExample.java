package com.gcontreras.springFramework.repaso.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Pointcut
 * Podemos tener dos aspectos que hacen uso del mismo pointcut, y si a futuro se cambia la ruta, en vez de ir a
 * modificar los dos aspectos podemos dejar una clase con una unica ruta.
 */

public class PointcutExample {
    @Pointcut("execution(* com.gcontreras.springFramework.repaso.aop.TargetObject.*(..)))")
    public void targetOjectMethods(){}
}
