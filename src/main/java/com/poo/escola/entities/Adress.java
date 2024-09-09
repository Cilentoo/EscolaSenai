package com.poo.escola.entities;

public class Adress {
    private String publicPlace;
    private int number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;

    public Adress(String publicPlace, int number, String complement,
                  String city, String state, String zipCode) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "Public Place ='" + publicPlace + '\'' +
                ", Number=" + number +
                ", Complement='" + complement + '\'' +
                ", City='" + city + '\'' +
                ", State='" + state + '\'' +
                ", Zip Code='" + zipCode + '\'' +
                '}';
    }

}
