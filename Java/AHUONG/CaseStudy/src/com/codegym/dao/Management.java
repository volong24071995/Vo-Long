package com.codegym.dao;

import com.codegym.entity.Student;

import java.text.DecimalFormat;
import java.util.*;

public class Management implements ManagementDAO {
    private Student student = new Student();
    Scanner scanner = new Scanner(System.in);
    DecimalFormat formatMark = new DecimalFormat("0.00");
    public  static FileUtil file = new FileUtil();
    public  static Regex validate = new Regex();
    public static HashMap<String, Student> studentList = new HashMap<String, Student>();

    public Management() {
    }

    @Override
    public void add() {
        studentList = file.getStudentList();
        Student newStudent = new Student();
        System.out.println("Please create new student code\n" +
                "Required: 'C***' - '*' is number from 0-9");
        String code = scanner.nextLine();
        while (!validate.validateCode(code)) {
            System.out.println("Incorrect student code. Please input again!\n"+
                    "Required: 'C***' - '*' is number from 0-9");
            code = scanner.nextLine();
        }
        newStudent.setStudentCode(code);
        System.out.println("Enter full name:");
        String name = scanner.nextLine();
        while (!validate.validateName(name)) {
            System.out.println("Invalid name. Please input again!");
            name = scanner.nextLine();
        }
        newStudent.setName(name);
        System.out.println("Enter gender: Male or Female");
        String gender = scanner.nextLine();
        while (!validate.validateGender(gender)) {
            System.out.println("Invalid gender. Please input 'Male' or 'Female'");
            gender = scanner.nextLine();
        }
        newStudent.setGender(gender);
        System.out.println("Enter class name\n" +
                "Required: 'C**' - '*' is number from 0-9");
        String className = scanner.nextLine();
        while (!validate.validateClass(className)) {
            System.out.println("Invalid class name. Please input again\n" +
                    "Required: 'C**' - '*' is number from 0-9");
            className = scanner.nextLine();
        }
        newStudent.setClassName(className);
        System.out.println("DOB - Enter year:");
        int year = Integer.parseInt(scanner.nextLine());
        while (!validate.validateYear(year)) {
            System.out.println("Invalid year. Please input again");
            year = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("DOB - Enter month:");
        int month = Integer.parseInt(scanner.nextLine());
        while (!validate.validateMonth(month)) {
            System.out.println("Invalid month. Please input again");
            month = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("DOB - Enter day:");
        int day = Integer.parseInt(scanner.nextLine());
        while (!validate.validateDay(year, month, day)) {
            System.out.println("Invalid day. Please input again");
            day = Integer.parseInt(scanner.nextLine());
        }
        String dob = day + "-" + month + "-" + year;
        newStudent.setDob(dob);
        double[] marks = {0,0,0,0};
        newStudent.setMark(marks);
        newStudent.setAverageMark(0);
        newStudent.setGrade("Ungraded");
        studentList.put(code, newStudent);
        file.saveStudentList(studentList);
        System.out.println("A new student had been added\n" +
                "--------------------");
    }

    @Override
    public void editInformation(String studentCode) {
        studentList = file.getStudentList();
        if (!studentList.containsKey(studentCode)) {
            System.out.println("Not found this student");
        } else {
            Student student1 = studentList.get(studentCode);
            System.out.println("Name: " + student1.getName() + ". Do you want to edit?\n" +
                    "Y: Yes\n" + "N: No");
            String selected = scanner.nextLine();
            switch (selected) {
                case "Y":
                    System.out.println("Enter full name:");
                    String name = scanner.nextLine();
                    while (!validate.validateName(name)) {
                        System.out.println("Invalid name. Please input again!");
                        name = scanner.nextLine();
                    }
                    student1.setName(name);
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Please press Y or N");
            }
            System.out.println("Gender: " + student1.getGender() + ". Do you want to edit?\n" +
                    "Y: Yes\n" + "N: No");
            selected = scanner.nextLine();
            switch (selected) {
                case "Y":
                    System.out.println("Enter gender: Male or Female");
                    String gender = scanner.nextLine();
                    while (!validate.validateGender(gender)) {
                        System.out.println("Invalid gender. Please input 'Male' or 'Female'");
                        gender = scanner.nextLine();
                    }
                    student1.setGender(gender);
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Please press Y or N");
            }
            System.out.println("Class name: " + student1.getClassName() + ". Do you want to edit?\n" +
                    "Y: Yes\n" + "N: No");
            selected = scanner.nextLine();
            switch (selected) {
                case "Y":
                    System.out.println("Enter class name\n" +
                            "Required: 'C**' - '*' is number from 0-9");
                    String className = scanner.nextLine();
                    while (!validate.validateClass(className)) {
                        System.out.println("Invalid class name. Please input again\n" +
                                "Required: 'C**' - '*' is number from 0-9");
                        className = scanner.nextLine();
                    }
                    student1.setClassName(className);
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Please press Y or N");
            }
            System.out.println("DOB: " + student1.getDob() + ". Do you want to edit?\n" +
                    "Y: Yes\n" + "N: No");
            selected = scanner.nextLine();
            switch (selected) {
                case "Y":
                    System.out.println("DOB - Enter year:");
                    int year = Integer.parseInt(scanner.nextLine());
                    while (!validate.validateYear(year)) {
                        System.out.println("Invalid year. Please input again");
                        year = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.println("DOB - Enter month:");
                    int month = Integer.parseInt(scanner.nextLine());
                    while (!validate.validateMonth(month)) {
                        System.out.println("Invalid month. Please input again");
                        month = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.println("DOB - Enter day:");
                    int day = Integer.parseInt(scanner.nextLine());
                    while (!validate.validateDay(year, month, day)) {
                        System.out.println("Invalid day. Please input again");
                        day = Integer.parseInt(scanner.nextLine());
                    }
                    String dob = day + "-" + month + "-" + year;
                    student1.setDob(dob);
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Please press Y or N");
            }
            studentList.put(studentCode, student1);
            file.saveStudentList(studentList);
            System.out.println("Information is updated\n" +
                    "--------------------");
        }
    }

    @Override
    public void delete(String studentCode) {
        studentList = file.getStudentList();
        if (!studentList.containsKey(studentCode)) {
            System.out.println("Not found this student");
        } else {
            System.out.println("Do you want to delete this student?\n" +
                    "Y: Yes\n" + "N: No");
            String selected = scanner.nextLine();
            switch (selected) {
                case "Y":
                    studentList.remove(studentCode);
                    System.out.println("Student " + studentCode + " is deleted\n" +
                            "--------------------");
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Please press Y or N");
            }
        }
        file.saveStudentList(studentList);
    }

    @Override
    public void printInfo(String studentCode) {
        studentList = file.getStudentList();
        if (!studentList.containsKey(studentCode)) {
            System.out.println("Not found this student");
        } else {
            Student student2 = studentList.get(studentCode);
            System.out.println("Student code: " + studentCode + "\n" +
                    "Name: " + student2.getName() + "\n" +
                    "Gender: " + student2.getGender() + "\n" +
                    "DOB: " + student2.getDob() + "\n" +
                    "Class: " + student2.getClassName() + "\n" +
                    "Marks: " + Arrays.toString(student2.getMark()) + "\n" +
                    "Average mark: " + formatMark.format(student2.getAverageMark()) + "\n" +
                    "Grade: " + student2.getGrade() + "\n" +
                    "--------------------");
        }
    }

    @Override
    public void inputMark(String studentCode) {
        studentList = file.getStudentList();
        if (!studentList.containsKey(studentCode)) {
            System.out.println("Not found this student");
        } else {
            Student student3 = studentList.get(studentCode);
            double[] marks = new double[4];
            System.out.println("Enter mark 1:");
            double mark1 = Double.parseDouble(scanner.nextLine());
            while (!validate.validateMark(mark1)) {
                System.out.println("Invalid mark. Please input again");
                mark1 = Double.parseDouble(scanner.nextLine());
            }
            marks[0] = mark1;
            System.out.println("Enter mark 2:");
            double mark2 = Double.parseDouble(scanner.nextLine());
            while (!validate.validateMark(mark2)) {
                System.out.println("Invalid mark. Please input again");
                mark2 = Double.parseDouble(scanner.nextLine());
            }
            marks[1] = mark2;
            System.out.println("Enter mark 3:");
            double mark3 = Double.parseDouble(scanner.nextLine());
            while (!validate.validateMark(mark3)) {
                System.out.println("Invalid mark. Please input again");
                mark3 = Double.parseDouble(scanner.nextLine());
            }
            marks[2] = mark3;
            System.out.println("Enter mark 4:");
            double mark4 = Double.parseDouble(scanner.nextLine());
            while (!validate.validateMark(mark4)) {
                System.out.println("Invalid mark. Please input again");
                mark4 = Double.parseDouble(scanner.nextLine());
            }
            marks[3] = mark4;
            double averageMark = calculateAverageScore(marks);
            String grade = grade(averageMark);
            student3.setMark(marks);
            student3.setAverageMark(averageMark);
            student3.setGrade(grade);
            studentList.put(studentCode, student3);
            file.saveStudentList(studentList);
            System.out.println("Marks are saved\n" +
                    "--------------------");
        }
    }

    @Override
    public double calculateAverageScore(double[] marks) {
        double averageMark = (marks[0] + marks[1] + marks[2]*2 + marks[3]*3)/7;
        return averageMark;
    }

    @Override
    public void updateMark(String studentCode) {
        studentList = file.getStudentList();
        if (!studentList.containsKey(studentCode)) {
            System.out.println("Not found this student");
        } else {
            Student student5 = studentList.get(studentCode);
            double[] marks = student5.getMark();
            System.out.println("Which mark do you want to update?\n" +
                    "1. Mark 1\n" +
                    "2. Mark 2\n" +
                    "3. Mark 3\n" +
                    "4. Mark 4\n" +
                    "0. Back to menu");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    break;
                case 1:
                    System.out.println("Enter new score 1:");
                    double mark1 = Double.parseDouble(scanner.nextLine());
                    while (!validate.validateMark(mark1)) {
                        System.out.println("Invalid mark. Please input again");
                        mark1 = Double.parseDouble(scanner.nextLine());
                    }
                    marks[0] = mark1;
                case 2:
                    System.out.println("Enter new score 2:");
                    double mark2 = Double.parseDouble(scanner.nextLine());
                    while (!validate.validateMark(mark2)) {
                        System.out.println("Invalid mark. Please input again");
                        mark2 = Double.parseDouble(scanner.nextLine());
                    }
                    marks[1] = mark2;
                case 3:
                    System.out.println("Enter new score 3:");
                    double mark3 = Double.parseDouble(scanner.nextLine());
                    while (!validate.validateMark(mark3)) {
                        System.out.println("Invalid mark. Please input again");
                        mark3 = Double.parseDouble(scanner.nextLine());
                    }
                    marks[2] = mark3;
                case 4:
                    System.out.println("Enter new score 4:");
                    double mark4 = Double.parseDouble(scanner.nextLine());
                    while (!validate.validateMark(mark4)) {
                        System.out.println("Invalid mark. Please input again");
                        mark4 = Double.parseDouble(scanner.nextLine());
                    }
                    marks[3] = mark4;
            }
            double averageMark = calculateAverageScore(marks);
            String grade = grade(averageMark);
            student5.setMark(marks);
            student5.setAverageMark(averageMark);
            student5.setGrade(grade);
            studentList.put(studentCode, student5);
            file.saveStudentList(studentList);
            System.out.println("Marks are saved\n" +
                    "--------------------");
        }
    }

    @Override
    public String grade(double averageMark) {
        String grade = "";
        if (averageMark < 5.0) {
            grade = "D";
        }
        if (averageMark < 6.5) {
            grade = "C";
        }
        if (averageMark < 8.0) {
            grade = "B";
        } else {
            grade = "A";
        }
        return grade;
    }

    public void viewStudentList() {
        studentList = file.getStudentList();
        String line = "+---------------------------------------------------------" +
                "----------------------------------------------------------------------------+";
        String lineHeader = "+====================================================" +
                "=================================================================================+";
        String header = "| Code  | NAME                          | Gender  | DOB            | " +
                "Class   | Mark 1 | Mark 2 | Mark 3 | Mark 4 | Average | Grade    |";
        System.out.println("Student Information:");
        System.out.println(lineHeader);
        System.out.println(header);
        System.out.println(lineHeader);
        List<Student> sortedList = new ArrayList<>(studentList.values());
        Collections.sort(sortedList);
        String code, name, gender, dob, className, mark1, mark2, mark3, mark4, average, grade;
        for (Student item: sortedList) {
            code = item.getStudentCode();
            name = item.getName();
            gender = item.getGender();
            dob = item.getDob();
            className = item.getClassName();
            double[] marks = item.getMark();
            mark1 = String.valueOf(marks[0]);
            mark2 = String.valueOf(marks[1]);
            mark3 = String.valueOf(marks[2]);
            mark4 = String.valueOf(marks[3]);
            average = formatMark.format(item.getAverageMark());
            grade = item.getGrade();
            System.out.format("| %-6s", code);
            System.out.format("| %-30s", name);
            System.out.format("| %-8s", gender);
            System.out.format("| %-15s", dob);
            System.out.format("| %-8s", className);
            System.out.format("| %-7s", mark1);
            System.out.format("| %-7s", mark2);
            System.out.format("| %-7s", mark3);
            System.out.format("| %-7s", mark4);
            System.out.format("| %-8s", average);
            System.out.format("| %-8s |", grade);
            System.out.println();
            System.out.println(line);
        }
    }

    public void exit() {
        System.exit(0);
    }
}
