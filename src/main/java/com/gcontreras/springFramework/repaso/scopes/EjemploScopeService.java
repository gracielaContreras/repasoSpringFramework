package com.gcontreras.springFramework.repaso.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class EjemploScopeService {

}
