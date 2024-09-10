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
		LocalDate localDate1 = LocalDate.of(2004, 10, 8);
		Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Adress adr1 = new Adress("Rua doutor joão barcelos", 126,
				"Casa A", "Petrópolis", FederalUnit.RJ, "25615171");


		Person student = new Student(Person.countRegistration,"17627006708", "Eduardo Cilento",
				date1, adr1, "(24)992568756", "cilento@gmail.com",
				"176270EM!m", "Curso Desenvolvimento de Software",
				new Date(),Situation.APPROVED);

		System.out.println(student);

	}


}
