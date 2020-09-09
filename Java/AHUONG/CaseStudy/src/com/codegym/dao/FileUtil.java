package com.codegym.dao;

import com.codegym.entity.Student;

import java.io.*;
import java.util.*;

public class FileUtil {
    private static final String fileName = "students.txt";
    private static Student student = new Student();

    public void saveStudentList(HashMap<String, Student> studentList) {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            List<Student> listStudent = new ArrayList<>(studentList.values());
            for (Student item: listStudent) {
                writer.append(item.getStudentCode());
                writer.append(",");
                writer.append(item.getName());
                writer.append(",");
                writer.append(item.getGender());
                writer.append(",");
                writer.append(item.getDob());
                writer.append(",");
                writer.append(item.getClassName());
                writer.append(",");
                writer.append(String.valueOf(item.getMark()[0]));
                writer.append(",");
                writer.append(String.valueOf(item.getMark()[1]));
                writer.append(",");
                writer.append(String.valueOf(item.getMark()[2]));
                writer.append(",");
                writer.append(String.valueOf(item.getMark()[3]));
                writer.append(",");
                writer.append(String.valueOf(item.getAverageMark()));
                writer.append(",");
                writer.append(item.getGrade());
                writer.append("\n");
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<String, Student> getStudentList() {
        HashMap<String, Student> studentList = new HashMap<String, Student>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(",");
                    Student stu = new Student();
                    stu.setStudentCode(temp[0]);
                    stu.setName(temp[1]);
                    stu.setGender(temp[2]);
                    stu.setDob(temp[3]);
                    stu.setClassName(temp[4]);
                    double[] marks = new double[4];
                    marks[0] = Double.parseDouble(temp[5]);
                    marks[1] = Double.parseDouble(temp[6]);
                    marks[2] = Double.parseDouble(temp[7]);
                    marks[3] = Double.parseDouble(temp[8]);
                    stu.setMark(marks);
                    stu.setAverageMark(Double.parseDouble(temp[9]));
                    stu.setGrade(temp[10]);
                    studentList.put(temp[0], stu);
                }
                fileReader.close();
            }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        return studentList;
    }
}
