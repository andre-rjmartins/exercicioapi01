package br.com.cotiinformatica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.cotiinformatica" })
public class ExercicioApi01Application {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioApi01Application.class, args);
	}

}
