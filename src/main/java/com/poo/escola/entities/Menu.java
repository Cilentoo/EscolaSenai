package com.poo.escola.entities;

import com.poo.escola.entities.enums.Situation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.poo.escola.entities.Student.getStudentByEmail;

public class Menu {
    private static Situation situation;
    private static String loggedUser = null;
    private static String userRole = null;

    public static void printRecord(String loggedUser) {
        Student student = getStudentByEmail(loggedUser);

        if (student != null){
            System.out.println("Student Record: ");
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getMail());

            Notes.loadNotesFromFile();

            List<Notes> studentNotes = new ArrayList<>();
            for(Notes note : Notes.getNotesList()){
                if (note.getStudent().equals(student)){
                    studentNotes.add(note);
                }
            }

            if (!studentNotes.isEmpty()){

                for (Notes note : studentNotes){
                    if (note.getNote() >= 6 ){
                        situation= Situation.APPROVED;
                        break;
                    }else if (note.getNote() < 3){
                        situation = Situation.FAILED;
                        break;
                    }else if (note.getNote() >= 3){
                        situation = Situation.IN_RECOVERY;
                        break;
                    }
                }
                System.out.println("Situation: " + situation.getStts());
                System.out.println("Notes: ");
                for (Notes note : studentNotes){
                    System.out.println("Discipline: " + note.getDiscipline().getDisciplineName());
                    System.out.println("Note: " + note.getNote());
                }
            }else {
                System.out.println("No notes found.");
            }
        }else {
            System.out.println("Student not found.");
        }
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Welcome to the system, enter with your login --");
        System.out.println("Email: ");
        String userMail = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        boolean isValidUser = false;


        for (Secretary s : Secretary.getSecretary()) {
            if (userMail.equals(s.getMail()) && password.equals(s.getPassword())) {
                loggedUser = userMail;
                userRole = "Secretary";
                System.out.println("Login sucessfully realized. (Secretary)!");
                isValidUser = true;

            }
        }
        for (Teacher t : Teacher.getTeachersList()) {
            if (userMail.equals(t.getMail()) && password.equals(t.getPassword())) {
                loggedUser = userMail;
                userRole = "Teacher";
                System.out.println("Login sucessfully realized. (Teacher)!");
                isValidUser = true;
            }
        }

        for (Student sT : Student.getStudentsList()) {
            if (userMail.equals(sT.getMail()) && password.equals(sT.getPassword())) {
                loggedUser = userMail;
                userRole = "Student";
                System.out.println("Login sucessfully realized. (Student)!");
                isValidUser = true;
            }
        }

        if (!isValidUser){
            System.out.println("Invalid email or password. Please try again");
            login();
        }
   }

        public static void menuFinal(){
            int optionM = 8;
            if (loggedUser == null){
                System.out.println("You need to log in first.");
                login();
            }

            do {
                    System.out.println("\n- MENU -");
                System.out.println("What do you want to do?");
                if(userRole.equals("Secretary")) {
                    System.out.println("1- Student Menu.");
                    System.out.println("2- Teacher menu:");
                }else if (userRole.equals("Teacher")){
                    System.out.println("1- Take notes");
                } else if (userRole.equals("Student")) {
                    System.out.println("1- My bill");
                }
                System.out.println("0- Exit\n");
                System.out.print("Digit an option: ");
                Scanner sc = new Scanner(System.in);
                try {
                    optionM = sc.nextInt();
                    System.out.println("\n");
                    switch (optionM) {

                        case 1:
                            if (userRole.equals("Secretary")) {
                                Secretary.secretaryMenuStudent();
                            }else if (userRole.equals("Teacher")){
                                Teacher.takeNotes();
                            }else if (userRole.equals("Student")){
                                Menu.printRecord(loggedUser);
                            }
                            break;
                        case 2:
                            if (userRole.equals("Secretary")) {
                                Secretary.secretaryMenuTeacher();
                            }else if (userRole.equals("Teacher")){
                                System.out.println("Take the notes: ");
                            }
                            break;
                        case 0:
                            System.out.println("Leaving");
                            loggedUser = null;
                            userRole = null;
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please send an integer number!");
                }

            }while(optionM != 0);

    }
}
