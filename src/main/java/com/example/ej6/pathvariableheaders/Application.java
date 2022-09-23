package com.example.ej6.pathvariableheaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

	@Bean
	ArrayList<Usuario> creaListaUsuarios(){
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
