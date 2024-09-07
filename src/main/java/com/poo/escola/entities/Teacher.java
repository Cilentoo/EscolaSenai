package com.poo.escola.entities;

import java.util.Date;

public class Teacher extends Person {
    private Date admissionDate;
    private Double salary;

    public Teacher(int registration, String cpf, String name, Date birthDate, Adress adress,
                   String telephone, String mail, String password,
                   Date admissionDate, Double salary) {
        super(registration, cpf, name, birthDate, adress, telephone, mail, password);
        this.admissionDate = admissionDate;
        this.salary = salary;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
