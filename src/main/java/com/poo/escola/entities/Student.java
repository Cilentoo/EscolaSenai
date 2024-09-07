package com.poo.escola.entities;

import java.util.Date;

public class Student extends Person{
    private Date dataRegistration;
    private String course;
    private Notes notes;


    public Student(int registration, String cpf, String name, Date birthDate, Adress adress,
                   String telephone, String mail,
                   String password, String course, Date dataRegistration, Notes notes) {

        super(registration, cpf, name, birthDate, adress, telephone, mail, password);
        this.course = course;
        this.dataRegistration = dataRegistration;
        this.notes = notes;
    }

    public Date getDataRegistration() {
        return dataRegistration;
    }

    public void setDataRegistration(Date dataRegistration) {
        this.dataRegistration = dataRegistration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
