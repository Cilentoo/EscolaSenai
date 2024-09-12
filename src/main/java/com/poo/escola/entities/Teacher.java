package com.poo.escola.entities;

import com.poo.escola.entities.controller.Bill;
import com.poo.escola.entities.controller.Login;
import com.poo.escola.entities.enums.Situation;

import java.io.FileWriter;
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
            for (Teacher t : teachersList){
                System.out.println((teachersList.indexOf(t))+ "- " + t.getName() + t.getSalary() +
                        t.getMail() + t.getAdmissionDate());
            }
        }else {
            System.out.println("There are no registered teacher. \n");
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

    public static void seedTeacher(){
        Teacher teacher1 = new Teacher();
        teacher1.setName("Arthur");
        teacher1.setSalary(3200.00);
        teacher1.setMail("arthurG@gmail.com");
        teacher1.setAdmissionDate(new Date());
        teachersList.add(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setName("Pedro");
        teacher2.setSalary(3200.00);
        teacher2.setMail("pedroG@gmail.com");
        teacher2.setAdmissionDate(new Date());
        teachersList.add(teacher2);

        Teacher teacher3 = new Teacher();
        teacher3.setName("Lucas");
        teacher3.setSalary(3200.00);
        teacher3.setMail("LucasG@gmail.com");
        teacher3.setAdmissionDate(new Date());
        teachersList.add(teacher2);

        Teacher teacher4 = new Teacher();
        teacher4.setName("Mario");
        teacher4.setSalary(3200.00);
        teacher4.setMail("marioG@gmail.com");
        teacher4.setAdmissionDate(new Date());
        teachersList.add(teacher4);
    }
}
