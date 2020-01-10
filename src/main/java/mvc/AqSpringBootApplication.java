package mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "mvc" })
@EnableJpaRepositories
@ComponentScan("mvc")
@EntityScan("mvc")
public class AqSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqSpringBootApplication.class, args);
	}

}
