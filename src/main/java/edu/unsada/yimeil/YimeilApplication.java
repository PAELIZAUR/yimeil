package edu.unsada.yimeil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"edu.unsada.yimeil.repository", "edu.unsada.yimeil.model"})  // Añadí 'edu.unsada.yimeil.model' para que escanee tus entidades
@EnableJpaRepositories(basePackages = "edu.unsada.yimeil.repository")  // Asegúrate de que Spring pueda encontrar tus repositorios
@EntityScan(basePackages = "edu.unsada.yimeil.model")  // Le indicamos a Spring que debe escanear el paquete de las entidades
public class YimeilApplication {

	public static void main(String[] args) {
		SpringApplication.run(YimeilApplication.class, args);
	}
}
