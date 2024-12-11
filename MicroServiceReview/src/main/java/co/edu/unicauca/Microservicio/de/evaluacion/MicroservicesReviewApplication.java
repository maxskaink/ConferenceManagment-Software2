package co.edu.unicauca.Microservicio.de.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("co.edu.unicauca.Microservicio.de.evaluacion.domain")
@EnableJpaRepositories("co.edu.unicauca.Microservicio.de.evaluacion.dao")
public class MicroservicesReviewApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesReviewApplication.class, args);
	}

}
