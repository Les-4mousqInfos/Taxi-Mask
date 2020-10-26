package fr.et.intechinfo.mousqinfos.taximask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //  Enabling JPA Auditing

public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	// ceci est un test git

}
