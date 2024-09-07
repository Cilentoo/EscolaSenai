package com.poo.escola.entities;

import java.util.Date;

public abstract class Person {
    //Atributos da classe pai
    private int registration;
    private String cpf;
    private String name;
    private Date birthDate;
    private Adress adress;
    private String telephone;
    private String mail;
    private String password;

    public Person(int registration, String cpf, String name,
                  Date birthDate, Adress adress, String telephone,
                  String mail, String password) {

        this.registration = registration;
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.adress = adress;
        this.telephone = telephone;
        this.mail = mail;
        this.password = password;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
