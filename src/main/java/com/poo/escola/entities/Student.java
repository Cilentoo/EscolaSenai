package com.poo.escola.entities;

import com.poo.escola.entities.enums.Situation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student extends Person{
    private Date dataRegistration;
    private String course;
    private Situation situation;

    public static List<Student> studentsList = new ArrayList<Student>();

    public Date getDataRegistration() {
        return dataRegistration;
    }

    public void setDataRegistration(Date dataRegistration) {
        this.dataRegistration = dataRegistration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dataRegistration=" + dataRegistration +
                ", course='" + course + '\'' +
                ", situation=" + situation.getStts() +
                '}';
    }

    public static void registerStudent(){
        System.out.println(" -- Registering new student -- ");
        System.out.println("Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Student student = new Student();
        student.setName(name);
        Student.studentsList.add(student);
    }


    public static void updateStudent(){
        if (!Student.studentsList.isEmpty()) {

            System.out.println("Student list: ");
            showStudentList();
            System.out.println("Enter number of the student to update: ");
            Scanner sc = new Scanner(System.in);
            int studentIndex = sc.nextInt() - 1;
            if (studentIndex >= 0 && studentIndex < Student.studentsList.size()) {
                Student studentToUpdate = Student.studentsList.get(studentIndex);
                System.out.println("Enter new name: ");
                sc.nextLine();
                String newName = sc.nextLine();
                studentToUpdate.setName(newName);
                System.out.println("Student updated succesfully. \n");
            } else {
                System.out.println("Invalid student number. \n");
            }
        }else {
            System.out.println("There are no registered students.");
        }
    }
    public static void removeStudent(){
        if (!Student.studentsList.isEmpty()) {

            System.out.println("Student list: ");
            showStudentList();
            System.out.println("Enter number of the student to remove: ");
            Scanner sc = new Scanner(System.in);
            int studentIndex = sc.nextInt() - 1;
            if (studentIndex >= 0 && studentIndex <= Student.studentsList.size()) {
                Student.studentsList.remove(studentIndex);
                System.out.println("Student removed succesfully. \n");
            } else {
                System.out.println("Invalid student number. \n");
            }
        }else {
            System.out.println("There are no registered students.");
        }
    }

    public static void showStudentList(){
        if(!Student.studentsList.isEmpty()){
            System.out.println("Student list: ");
            for (int i = 0; i< Student.studentsList.size(); i++){
                System.out.println((i+1) + "- " + Student.studentsList.get(i).getName());
            }
        }else {
            System.out.println("There are no registered students. \n");
        }
    }
}
