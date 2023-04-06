package com.gcontreras.springFramework.repaso;

import com.gcontreras.springFramework.repaso.aop.TargetObject;
import com.gcontreras.springFramework.repaso.autowired.CalcularAreaService;
import com.gcontreras.springFramework.repaso.profile.EnviromentService;
import com.gcontreras.springFramework.repaso.scopes.EjemploScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
@SpringBootApplication
public class RepasoApplication {
	private static final Logger log= LoggerFactory.getLogger(RepasoApplication.class);

	//Declaración de beans de forma explicita
	@Bean //defino el objeto que se va a devolver cuando se inyecte un bean de tipo String
	@Primary
	public String getApplicationName() {
		return "Repaso Spring Framework";
	};
	@Bean
	public String getApplicationName2() {
		return "Repaso Spring Framework2";
	};

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(RepasoApplication.class, args);
/*		EnviromentService env = context.getBean(EnviromentService.class);
		log.info("El entorno que estoy utilizando es: {}", env.getEnviroment());

		log.info("Probando spring scopes");
		EjemploScopeService scope = context.getBean(EjemploScopeService.class);
		EjemploScopeService scope1 = context.getBean(EjemploScopeService.class);
		log.info("Are beans equals {} ", scope.equals(scope1));
		log.info("Are beans == {} ", scope == scope1);

		log.info("Declaración de beans de forma explicita");
		String nombreAplicacion = context.getBean("getApplicationName2", String.class);
		log.info("Nombre de la aplicación {}", nombreAplicacion);

		log.info("Probando inyectando multiples objetos");
		CalcularAreaService calcArea = context.getBean(CalcularAreaService.class);
 		log.info("La suma de las area es: {} ", calcArea.getTotalAreas());*/

		log.info("Aop Programación orientada a aspecto");
		TargetObject targetObject = context.getBean(TargetObject.class);
		targetObject.hello("Hello World");
		targetObject.foo();

	}

}
