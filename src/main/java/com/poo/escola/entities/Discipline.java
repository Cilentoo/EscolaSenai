package com.poo.escola.entities;

public class Discipline {
    private String disciplineName;
    private Notes notes;
    private Teacher teacher;

    public Discipline(String disciplineName, Notes notes, Teacher teacher) {
        this.disciplineName = disciplineName;
        this.notes = notes;
        this.teacher = teacher;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
