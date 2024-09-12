package com.poo.escola.entities;

import java.util.ArrayList;
import java.util.List;

public class Notes {
    private int Notes;
    private Student student;
    private Discipline discipline;



    public Notes(int notes, Student student, Discipline discipline) {
        Notes = notes;
        this.student = student;
        this.discipline = discipline;
    }

    public int getNotes() {
        return Notes;
    }

    public void setNotes(int notes) {
        Notes = notes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
