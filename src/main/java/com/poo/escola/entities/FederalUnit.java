package com.poo.escola.entities;

public enum FederalUnit {
    RJ("Rio de Janeiro"),
    SP("São Paulo"),
    MG("Minas Gerais"),
    ES("Espírito Santo"),


    PR("Paraná"),
    SC("Santa Catarina"),
    RS("Rio Grande do Sul"),


    DF("Distrito Federal"),
    GO("Goiás"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),


    AL("Alagoas"),
    BA("Bahia"),
    CE("Ceará"),
    MA("Maranhão"),
    PB("Paraíba"),
    PE("Pernambuco"),
    PI("Piauí"),
    RN("Rio Grande do Norte"),
    SE("Sergipe"),


    AC("Acre"),
    AP("Amapá"),
    AM("Amazonas"),
    PA("Pará"),
    RO("Rondônia"),
    RR("Roraima"),
    TO("Tocantins");

    private final String nameInFull;

    FederalUnit(String nameInFull){
        this.nameInFull = nameInFull;
    }

    public String getNameInFull() {
        return nameInFull;
    }
}

