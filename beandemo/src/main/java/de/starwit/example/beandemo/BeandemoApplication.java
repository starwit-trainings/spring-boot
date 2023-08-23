package de.starwit.example.beandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"de.starwit.example.beandemo"})
@ComponentScan(basePackageClasses = ConfiguredBean.class)
public class BeandemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeandemoApplication.class, args);
	}

	@Bean(initMethod = "init")
	public SimpleBean getSimpleBean() {
		return new SimpleBean();
	}

	@Bean(initMethod = "init")
	public ConfiguredBean getConfiguredBean() {
		return new ConfiguredBean();
	}
}
