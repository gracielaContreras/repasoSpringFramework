package com.gcontreras.springFramework.repaso.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QualifiersApplication {
	private static Logger logger = LoggerFactory.getLogger(QualifiersApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QualifiersApplication.class, args);

		Pajaro pajaro = context.getBean(Pajaro.class);
		pajaro.volar();
		logger.info("Me llamo: {}", pajaro.getNombre());

		Perro perro = context.getBean(Perro.class);
		logger.info("voy de paseo con mi perro {} que tiene {} año", perro.getNombre(), perro.getEdad());

		//probando el qualifiers
		// 1° forma a través del contexto
		Animal animal = context.getBean("perro", Animal.class); //especifico el nombre de la clase que quiero utilizar
		logger.info("voy de paseo con mi perro {} que tiene {} año", animal.getNombre(), animal.getEdad());
		// 2° forma. En clase Nido se agrega el @Qualifier a utilizar
		Nido nido = context.getBean(Nido.class);
		nido.imprimir();
	}

}
