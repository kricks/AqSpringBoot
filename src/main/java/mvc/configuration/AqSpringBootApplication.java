package mvc.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mvc.controller.Hello;

@SpringBootApplication
public class AqSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hello.class, args);
	}

}
