package pl.chyla.luxdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LuxdocAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuxdocAppApplication.class, args);
	}
}
