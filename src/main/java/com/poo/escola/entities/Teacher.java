package com.poo.escola.entities;


import com.poo.escola.entities.enums.Situation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person {
    private Date admissionDate;
    private Double salary;

    public static List<Teacher> teachersList = new ArrayList<Teacher>();

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public static void registerTeacher() {
        System.out.println(" -- Registering new teacher -- ");
        System.out.println("Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Teacher teacher = new Teacher();
        teacher.setName(name);
        Teacher.teachersList.add(teacher);
    }

    public static void updateTeacher() {
        if (!Teacher.teachersList.isEmpty()) {

            System.out.println("Teacher list: ");
            showTeacherList();
            System.out.println("Enter number of the teacher to update: ");
            Scanner sc = new Scanner(System.in);
            int teacherIndex = sc.nextInt() - 1;
            if (teacherIndex >= 0 && teacherIndex < Teacher.teachersList.size()) {
                Teacher teacherToUpdate = Teacher.teachersList.get(teacherIndex);
                System.out.println("Enter new name: ");
                sc.nextLine();
                String newName = sc.nextLine();
                teacherToUpdate.setName(newName);
                System.out.println("Teacher updated succesfully. \n");
            } else {
                System.out.println("Invalid Teacher number. \n");
            }
        } else {
            System.out.println("There are no registered teachers.");
        }
    }

    public static void removeTeacher() {
        if (!Teacher.teachersList.isEmpty()) {

            System.out.println("Teachers list: ");
            showTeacherList();
            System.out.println("Enter number of the teacher to remove: ");
            Scanner sc = new Scanner(System.in);
            int teacherIndex = sc.nextInt() - 1;
            if (teacherIndex >= 0 && teacherIndex <= Teacher.teachersList.size()) {
                Teacher.teachersList.remove(teacherIndex);
                System.out.println("Teacher removed succesfully. \n");
            } else {
                System.out.println("Invalid teacher number. \n");
            }
        } else {
            System.out.println("There are no registered teachers.");
        }
    }

    public static void showTeacherList() {
        if (!Teacher.teachersList.isEmpty()) {
            System.out.println("Teacher list: ");
            for (Teacher t : teachersList) {
                System.out.println((teachersList.indexOf(t)) + "- " + t.getName() + " / salary: " +
                        t.getSalary()
                        + "/ email: " + t.getMail() + " / admission date: "
                        + t.getAdmissionDate());
            }
        } else {
            System.out.println("There are no registered teacher. \n");
        }
    }


    public static void seedTeacher() {
        Teacher teacher1 = new Teacher();
        teacher1.setName("Arthur");
        teacher1.setSalary(3200.00);
        teacher1.setMail("arthurG@gmail.com");
        teacher1.setAdmissionDate(new Date());
        teacher1.setPassword("MA@!1999");
        teachersList.add(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setName("Pedro");
        teacher2.setSalary(3200.00);
        teacher2.setMail("pedroG@gmail.com");
        teacher2.setAdmissionDate(new Date());
        teacher2.setPassword("PE@!1999");

        teachersList.add(teacher2);

        Teacher teacher3 = new Teacher();
        teacher3.setName("Lucas");
        teacher3.setSalary(3200.00);
        teacher3.setMail("LucasG@gmail.com");
        teacher3.setAdmissionDate(new Date());
        teacher3.setPassword("LU@!1999");

        teachersList.add(teacher3);

        Teacher teacher4 = new Teacher();
        teacher4.setName("Mario");
        teacher4.setSalary(3200.00);
        teacher4.setMail("marioG@gmail.com");
        teacher4.setAdmissionDate(new Date());
        teacher4.setPassword("MA@!1999");
        teachersList.add(teacher4);
    }

    public static void takeNotes() {
        System.out.println("Taking notes");
        Student.showStudentList();
        System.out.println("Enter number of the student to take notes: ");
        Scanner sc = new Scanner(System.in);
        int studentIndex = sc.nextInt() - 1;
        if (studentIndex >= 0 && studentIndex <= Student.getStudentsList().size()) {
            Discipline.showDisciplineList();
            System.out.println("Okay, for now enter number of discipline you want to take notes: ");
            int disciplineIndex = sc.nextInt() - 1;
            if (disciplineIndex >= 0 && disciplineIndex <= Discipline.getDisciplineList().size()) {
                Notes note = new Notes();
                System.out.println("Qual nota do aluno: ");
                Double takeNote1 = sc.nextDouble();
                note.setNote(takeNote1);
                note.setStudent(Student.getStudentsList().get(studentIndex));
                note.setDiscipline(Discipline.getDisciplineList().get(disciplineIndex));
                Notes.notesList.add(note);
                Notes.saveNotesToFile();
            }

        } else {
            System.out.println("Invalid Student number. \n");
        }

    }


    public static List<Teacher> getTeachersList() {
        return teachersList;
    }
}
