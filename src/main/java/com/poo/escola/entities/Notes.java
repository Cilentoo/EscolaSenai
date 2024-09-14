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
        this.note = note;
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
        File file = new File("notes.txt");
        System.out.println("Saving notes to file: " + file.getAbsolutePath());
        if (!file.canWrite()) {
            System.out.println("No write permission to the file. Trying to grant write permission...");
            file.setWritable(true); // Grant write permission to the file
        }
        if (file.exists()) {
            file.delete(); // Delete the file if it already exists
        }
        try {
            file.createNewFile(); // Create a new file
        } catch (IOException e) {
            System.err.println("Error creating new file: " + e.getMessage());
            return; // Exit the method if there's an error creating the file
        }
        try (FileWriter writer = new FileWriter("notes.txt", true)) {
            for (Notes note : notesList) {
                writer.write(note.getStudent().getMail() + "," + note.getDiscipline().getDisciplineName() + "," + note.getNote() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadNotesFromFile() {
        File file = new File("notes.txt");
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        notesList.clear(); // Clear the list before loading new data

        try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


    private static void processLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid line format: " + line);
            return;
        }

        Student student = Student.getStudentByEmail(parts[0]);
        Discipline discipline = Discipline.getDisciplineByName(parts[1]);

        if (student != null && discipline != null) {
            try {
                Double note = Double.parseDouble(parts[2]);
                Notes noteObject = new Notes();
                noteObject.setStudent(student);
                noteObject.setDiscipline(discipline);
                noteObject.setNote(note);
                student.addNote(noteObject);
                discipline.addNote(noteObject);
                Notes.getNotesList().add(noteObject);
            } catch (NumberFormatException e) {
                System.out.println("Invalid note format: " + parts[2]);
            }
        } else {
            System.out.println("Error loading note: Student or discipline not found");
        }
    }

}

