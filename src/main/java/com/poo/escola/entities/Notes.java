package com.poo.escola.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Notes {
    private Double note;
    private Student student;
    private Discipline discipline;

    public static List<Notes> notesList = new ArrayList<Notes>();

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        note = note;
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

    public static List<Notes> getNotesList() {
        return notesList;
    }

    public static void saveNotesToFile() {
        try (FileWriter writer = new FileWriter("C:/Users/Usuario/Documentos/SerraTec-2024-2/JavaPoo1/escola/notes.txt")) {
            for (Notes note : notesList) {
                writer.write(note.getStudent().getName() + "," + note.getDiscipline().getDisciplineName() + "," + note.getNote() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

        public static void loadNotesFromFile(){
            try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Usuario/Documentos/SerraTec-2024-2/JavaPoo1/escola/notes.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    Student student = Student.getStudentByEmail(parts[0]);
                    Discipline discipline = Discipline.getDisciplineByName(parts[1]);
                    if (student != null && discipline != null) {
                        Double note = Double.parseDouble(parts[2]);
                        Notes noteObject = new Notes();
                        noteObject.setStudent(student);
                        noteObject.setDiscipline(discipline);
                        noteObject.setNote(note);
                        notesList.add(noteObject);
                    } else System.out.println("Error loading note: Student or discipline not found");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

