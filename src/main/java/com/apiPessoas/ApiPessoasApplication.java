package com.apiPessoas;

import com.apiPessoas.models.Person;
import com.apiPessoas.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication

public class ApiPessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPessoasApplication.class, args);
	}

}
