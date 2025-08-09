package com.web;


import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println(" Student Grade Tracker ");

        System.out.print("Enter total number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

      
        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Grade (0-100): ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); 

            students.add(new Student(name, grade));
        }

       
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "";
        String lowStudent = "";

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = total / students.size();
        System.out.println("\n Grade Summary Report");
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Grade : " + lowest + " (by " + lowStudent + ")");

        System.out.println("\n Student List:");
        for (Student s : students) {
            System.out.println("- " + s.name + ": " + s.grade);
        }

        scanner.close();
    }
}


