package com.poo.escola.entities.controller;

import com.poo.escola.entities.Discipline;
import com.poo.escola.entities.Notes;
import com.poo.escola.entities.Student;
import com.poo.escola.entities.enums.Situation;

public interface Bill {

    public void printBill(Student student, Notes notes, Situation situation,
                                 Discipline discipline);
}
