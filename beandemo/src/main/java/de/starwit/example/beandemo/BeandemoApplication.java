package de.starwit.example.beandemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@Bean(initMethod = "init", name = "sBean")
	public SimpleBean getAnotherSimpleBean() {
		return new SimpleBean();
	}	

	@Bean(initMethod = "init")
	public ConfiguredBean getConfiguredBean() {
		return new ConfiguredBean();
	}
}
