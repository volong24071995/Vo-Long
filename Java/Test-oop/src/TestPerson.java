import java.util.Calendar;
import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person=new Person("Long",1992);
        int year = Calendar.getInstance().get(Calendar.YEAR);
       int age=year-person.getNamsinh();
        System.out.println(age);
    }
}