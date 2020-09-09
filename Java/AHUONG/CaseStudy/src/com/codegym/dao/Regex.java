package com.codegym.dao;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean validateName(String name) {
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public static boolean validateCode(String code) {
        String regx = "^[C]+[0-9]{3}$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(code);
        return matcher.find();
    }

    public static boolean validateClass(String className) {
        String regx = "^[C]+[0-9]{2}$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(className);
        return matcher.find();
    }

    public static boolean validateMark(double mark) {
        if (mark > 0.0 && mark <= 10.0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateGender(String gender) {
        if (gender.equals("Male") || gender.equals("Female")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateYear(int year) {
        if (year > 1900 && year < 2020) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateMonth(int month) {
        if (month > 0 && month < 13) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateDay(int year,int month,int day) {
        boolean isCorrected = false;
        switch (month) {
            case 1,3,5,7,8,10,12:
                if (day > 0 && day < 32) {
                    isCorrected = true;
                }
                break;
            case 4,6,9,11:
                if (day > 0 && day < 31) {
                    isCorrected = true;
                }
                break;
            case 2:
                if (isLeapYear(year) && day > 0 && day < 30) {
                    isCorrected = true;
                }
                if (!isLeapYear(year) && day > 0 && day < 29) {
                    isCorrected = true;
                }
                break;
        }
        return isCorrected;
    }

    public static boolean isLeapYear(int year) {
        GregorianCalendar cal = new GregorianCalendar();
        if(cal.isLeapYear(year)) {
            return true;
        } else return false;
    }

}
