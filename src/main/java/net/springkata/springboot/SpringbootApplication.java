package net.springkata.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
	    SpringApplication.run(SpringbootApplication.class, args);
//		SpringApplication app = new SpringApplication(SpringbootApplication.class);
//		app.setDefaultProperties(Collections
//				.singletonMap("server.port", "8085"));
//		app.run(args);
	}

}
