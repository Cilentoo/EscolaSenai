package com.poo.escola.entities;

import com.poo.escola.entities.controller.Bill;
import com.poo.escola.entities.controller.Login;
import com.poo.escola.entities.enums.Situation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person implements Login, Bill {
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

    public static void registerTeacher(){
        System.out.println(" -- Registering new teacher -- ");
        System.out.println("Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Teacher teacher= new Teacher();
        teacher.setName(name);
        Teacher.teachersList.add(teacher);
    }

    public static void updateTeacher(){
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
        }else {
            System.out.println("There are no registered teachers.");
        }
    }
    public static void removeTeacher(){
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
        }else {
            System.out.println("There are no registered teachers.");
        }
    }

    public static void showTeacherList(){
        if(!Teacher.teachersList.isEmpty()){
            System.out.println("Teacher list: ");
            for (int i = 0; i< Teacher.teachersList.size(); i++){
                System.out.println((i+1) + "- " + Teacher.teachersList.get(i).getName());
            }
        }else {
            System.out.println("There are no registered customers. \n");
        }
    }

    @Override
    public boolean acessAllowed(String mail, String password) {
        if (mail.equals(getMail()) && password.equals(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printBill(Student student, Notes notes, Situation situation,
                          Discipline discipline) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student: " + student.getName());
        int note = sc.nextInt();
        notes.setNotes(note);
        System.out.println("Note: " + notes.getNotes());
        System.out.println("Situation: " + situation.getStts());
        System.out.println("Discipline: " + discipline.getDisciplineName());

    }
}
