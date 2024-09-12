package com.poo.escola.entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static void menuFinal(){
        int optionM = 8;
        do{

                System.out.println("\n- MENU -");
                System.out.println("What do you want to do?");
                System.out.println("1- Student Menu.");
                System.out.println("2- Teacher menu:");
                System.out.println("0- Exit\n");
                System.out.print("Digit an option: ");
                Scanner sc = new Scanner(System.in);
            try {
                optionM = sc.nextInt();
                System.out.println("\n");
                switch (optionM) {

                    case 1:
                        Secretary.secretaryMenuStudent();
                        break;
                    case 2:
                        Secretary.secretaryMenuTeacher();
                        break;
                    case 0:
                        System.out.println("Leaving");
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Please send an integer number!");
            }
        }while(optionM != 0);

}
}
