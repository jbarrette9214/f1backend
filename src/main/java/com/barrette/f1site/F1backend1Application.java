package com.barrette.f1site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class F1backend1Application {

	public static void main(String[] args) {
		SpringApplication.run(F1backend1Application.class, args);
	}

}
