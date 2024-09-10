package com.poo.escola.entities;

import java.util.Date;

public class Student extends Person{
    private Date dataRegistration;
    private String course;
    private Situation situation;


    public Student(int registration, String cpf, String name, Date birthDate, Adress adress,
                   String telephone, String mail,
                   String password, String course, Date dataRegistration,
                   Situation situation) {

        super(registration, cpf, name, birthDate, adress, telephone, mail, password);
        this.course = course;
        this.dataRegistration = dataRegistration;
        this.situation = situation;
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

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dataRegistration=" + dataRegistration +
                ", course='" + course + '\'' +
                ", situation=" + situation.getStts() +
                '}';
    }

}
