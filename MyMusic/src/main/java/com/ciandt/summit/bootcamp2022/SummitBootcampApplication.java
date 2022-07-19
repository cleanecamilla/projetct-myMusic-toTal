package com.ciandt.summit.bootcamp2022;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SummitBootcampApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SummitBootcampApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Inicializando Aplicação");
		SpringApplication.run(SummitBootcampApplication.class, args);
		LOGGER.info("Aplicação inicializada!");
	}

}
