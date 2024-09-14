package com.poo.escola.entities;


import com.poo.escola.entities.enums.Situation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student extends Person{
    private Date dataRegistration;
    private String course;
    private Notes notes;
    private static Situation situation;

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

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
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
            if (studentIndex >= 0 && studentIndex < Student.studentsList.size()) {
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
            for (Student s : studentsList){
                System.out.println((studentsList.indexOf(s))+ "- " + s.getName() + " / data registration: " +
                        s.getDataRegistration() + " / email: " + s.getMail() + " / course: "
                        + s.getCourse());
            }
        }else {
            System.out.println("There are no registered students. \n");
        }
    }


    public static void seedStudent(){
        Student student1 = new Student();
        student1.setName("Luan");
        student1.setMail("luanG@gmail.com");
        student1.setCourse("Desenvolvimento de Software");
        student1.setPassword("Lu!1984@");
        studentsList.add(student1);

        Student student2 = new Student();
        student2.setName("Carlos");
        student2.setDataRegistration(new Date());
        student2.setMail("carlosS@gmail.com");
        student2.setCourse("Desenvolvimento de Software");
        studentsList.add(student2);

        Student student3 = new Student();
        student3.setName("Marcos");
        student3.setDataRegistration(new Date());
        student3.setMail("marcosS@gmail.com");
        student3.setCourse("Desenvolvimento de Software");
        studentsList.add(student3);

    }

    public static List<Student> getStudentsList(){
        return studentsList;
    }

    public static Student getStudentByEmail(String email){
        for (Student student : studentsList){
            if (student.getMail().equals(email)){
                return student;
            }
        }
        return null;
    }

}
