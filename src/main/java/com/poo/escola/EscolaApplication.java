package com.poo.escola;

import com.poo.escola.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args)  {
		SpringApplication.run(EscolaApplication.class, args);
		Secretary.seedSecretary();
		Student.seedStudent();
		Teacher.seedTeacher();
		Menu.menuFinal();

	}


}
