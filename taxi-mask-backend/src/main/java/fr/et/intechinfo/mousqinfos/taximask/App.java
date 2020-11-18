package fr.et.intechinfo.mousqinfos.taximask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
@EnableJpaAuditing //  Enabling JPA Auditing
public class App {
	@Value("${cors.allowed_origins}")
	String corsAllowedOrigins;
	private static Logger logger = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	// ceci est un test git

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				logger.info(corsAllowedOrigins);
				registry.addMapping("/**").allowedOrigins(corsAllowedOrigins).allowCredentials(true);
			}
		};
	}

}
