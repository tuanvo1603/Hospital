package project.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import project.hospital.configuration.databaseconfig.DatabaseConfig;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "project.hospital.repository")
@ComponentScan(basePackages = "project.hospital")
@EntityScan(basePackages = "project.hospital.model")
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
}
