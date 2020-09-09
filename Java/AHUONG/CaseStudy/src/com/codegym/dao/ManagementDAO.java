package com.codegym.dao;

public interface ManagementDAO {
    void add();
    void editInformation(String studentCode);
    void delete(String studentCode);
    void printInfo(String studentCode);
    void inputMark(String studentCode);
    void updateMark(String studentCode);
    double calculateAverageScore(double[] marks);
    String grade(double averageMark);
}
