package com.poo.escola;

import com.poo.escola.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);

		Menu.menuFinal();

	}


}
