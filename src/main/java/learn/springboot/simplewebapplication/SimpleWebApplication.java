package learn.springboot.simplewebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan(basePackages = {"learn/springboot/simplewebapplication"})
@Configuration
@EnableAutoConfiguration
public class SimpleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApplication.class, args);

	}



}
