package com.poo.escola.entities;

import com.poo.escola.entities.controller.Login;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Secretary extends Person implements Login {
    @Override
    public boolean acessAllowed(String mail, String password) {
        if (mail.equals(getMail()) && password.equals(getPassword())){
            return true;
        }else {
            return false;
        }
    }

    public static void secretaryMenuStudent(){
        int optionS = 8;

        do{
            System.out.println("\n- MENU -");
            System.out.println("What do you want to do?");
            System.out.println("1- Register new student");
            System.out.println("2- Update student");
            System.out.println("3- Delete student");
            System.out.println("4- List student");
            System.out.println("0- Exit\n");
            System.out.print("Digit an option: ");
            Scanner sc = new Scanner(System.in);
            try {

                optionS = sc.nextInt();
                System.out.println("\n");
                switch (optionS) {
                    case 1:
                        Student.registerStudent();
                        break;
                    case 2:
                        Student.updateStudent();
                        break;
                    case 3:
                        Student.removeStudent();
                        break;
                    case 4:
                        Student.showStudentList();
                        break;
                    case 0:
                        System.out.println("Leaving...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Please send an integer number!");
            }
        }while(optionS != 0);
    }

    public static void secretaryMenuTeacher(){
        int optionT = 8;

        do{
            System.out.println("\n- MENU -");
            System.out.println("What do you want to do?");
            System.out.println("1- Register new teacher");
            System.out.println("2- Update teacher");
            System.out.println("3- Delete teacher");
            System.out.println("4- List teacher");
            System.out.println("0- Exit\n");
            System.out.print("Digit an option: ");
            Scanner sc = new Scanner(System.in);
            try {
                optionT = sc.nextInt();
                System.out.println("\n");
                switch (optionT) {
                    case 1:
                        Teacher.registerTeacher();
                        break;
                    case 2:
                        Teacher.updateTeacher();
                        break;
                    case 3:
                        Teacher.removeTeacher();
                        break;
                    case 4:
                        Teacher.showTeacherList();
                        break;
                    case 0:
                        System.out.println("Leaving...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Please send an integer number!");
            }
        }while(optionT != 0);
    }
}
