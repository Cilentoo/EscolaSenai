package com.poo.escola.entities;

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

    public static void registerStudent(){
        System.out.println(" -- Registering new student -- ");
        System.out.println("Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Student student = new Student();
        student.setName(name);
        Student.studentsList.add(student);
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
}
