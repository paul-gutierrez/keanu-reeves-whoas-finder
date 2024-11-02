package com.cursoAluraLambdas.desafio_lambdasStreams;

import com.cursoAluraLambdas.desafio_lambdasStreams.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLambdasStreamsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioLambdasStreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraMuenu();
	}
}
