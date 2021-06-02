package com.fabiofrasson.prova01jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("api")
public class Prova01junApplication {

	public static void main(String[] args) {
		SpringApplication.run(Prova01junApplication.class, args);
	}

}
