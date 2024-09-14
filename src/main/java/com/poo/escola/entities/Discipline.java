package com.poo.escola.entities;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private String disciplineName;
    private Notes notes;

    public static List<Discipline> disciplineList = new ArrayList<Discipline>();

    public static Discipline getDisciplineByName(String name) {
        for (Discipline discipline : disciplineList) {
            if (discipline.getDisciplineName().equals(name)) {
                return discipline;
            }
        }
        return null;
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


    public static List<Discipline> getDisciplineList(){
        return disciplineList;
    }

    public static void showDisciplineList(){
        if(!Discipline.disciplineList.isEmpty()){
            System.out.println("Discipline list: ");
            for (Discipline d : disciplineList){
                System.out.println((disciplineList.indexOf(d))+ "- " + d.getDisciplineName());
            }
        }else {
            System.out.println("There are no registered disciplines. \n");
        }
    }


    public static void seedDiscipline(){
        Discipline discipline1 = new Discipline();
        discipline1.setDisciplineName("JAVA");
        disciplineList.add(discipline1);

        Discipline discipline2 = new Discipline();
        discipline2.setDisciplineName("LOGIC");
        disciplineList.add(discipline2);

        Discipline discipline3 = new Discipline();
        discipline3.setDisciplineName("DBA");
        disciplineList.add(discipline3);
    }
}
