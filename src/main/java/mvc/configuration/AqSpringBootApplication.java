package mvc.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "mvc" })
public class AqSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqSpringBootApplication.class, args);
	}

}
