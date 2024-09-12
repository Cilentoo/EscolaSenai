package com.poo.escola.entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static String loggedUser = null;
    private static String userRole = null;


    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Welcome to the system, enter with your login --");
        System.out.println("Email: ");
        String userMail = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();


        for(Secretary s : Secretary.getSecretary()) {
            if (userMail.equals(s.getMail()) && password.equals(s.getPassword())) {
                loggedUser = userMail;
                userRole = "Secretary";
                System.out.println("Login sucessfully realized. (Secretary)!");
            }
        }
        for (Teacher t: Teacher.getTeachersList()) {
            if (userMail.equals(t.getMail()) &&password.equals(t.getPassword())){
                loggedUser = userMail;
                userRole = "Teacher";
                System.out.println("Login sucessfully realized. (Teacher)!");
            }
        }

        for (Student sT : Student.getStudentsList()) {
            if (userMail.equals(sT.getMail()) && password.equals(sT.getPassword())) {
                loggedUser = userMail;
                userRole = "Student";
                System.out.println("Login sucessfully realized. (Student)!");
            }
        }
        if(userMail.isEmpty() || password.isEmpty()){
            System.out.println("Invalid User mail or password.");
            loggedUser = null;
            userRole = null;
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
                    System.out.println("1- Print bill");
                    System.out.println("2- Give note");
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
                                System.out.println("The bill has been printed");
                            }else if (userRole.equals("Student")){
                                System.out.println("Printing bill");
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
