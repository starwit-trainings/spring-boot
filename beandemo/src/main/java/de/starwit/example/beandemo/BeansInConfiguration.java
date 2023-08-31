package de.starwit.example.beandemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansInConfiguration {

    private Logger log = LoggerFactory.getLogger(BeansInConfiguration.class);

    @Bean(name = "sBeanList")
	public List<SimpleBean> beanList() {
		List<SimpleBean> list =  new ArrayList<>();
		SimpleBean b = new SimpleBean();
		b.setAge(5);
		b.setName("Test");
		list.add(b);

		return list;
	}
}
