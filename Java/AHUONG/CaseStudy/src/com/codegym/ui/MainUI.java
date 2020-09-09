package com.codegym.ui;

import com.codegym.dao.Management;
import com.codegym.entity.Student;

import java.util.Scanner;

public class MainUI {
    public static Management management = new Management();
    public static Student student = new Student();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewInstruction();
        implement();
    }

    public static void viewInstruction() {
        System.out.println("1. Add new student\n" +
                "2. Edit information\n" +
                "3. Delete a student\n" +
                "4. Print student's information\n" +
                "5. View all students\n" +
                "6. Input student's marks\n" +
                "7. Edit student's marks\n" +
                "0. Exit\n" +
                "--------------------");
    }

    public static void implement() {
        int selected = Integer.parseInt(scanner.nextLine());
        while (selected != 0) {
            switch (selected) {
                case 1:
                    management.add();
                    break;
                case 2:
                    management.editInformation(inputStudentCode());
                    break;
                case 3:
                    management.delete(inputStudentCode());
                    break;
                case 4:
                    management.printInfo(inputStudentCode());
                    break;
                case 5:
                    management.viewStudentList();
                    break;
                case 6:
                    management.inputMark(inputStudentCode());
                    break;
                case 7:
                    management.updateMark(inputStudentCode());
                    break;
                default:
                    System.out.println("Please select as instruction");
            }
            viewInstruction();
            selected = Integer.parseInt(scanner.nextLine());
        }
        if (selected == 0) {
            management.exit();
        }
    }

    public static String inputStudentCode() {
        System.out.println("Enter student's code");
        String studentCode = scanner.nextLine();
        return studentCode;
    }
}
