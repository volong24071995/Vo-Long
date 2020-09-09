import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement implements Comparator<Student> {
    private final ArrayList<Student> studentsList=new ArrayList<>();
    Scanner sc=new Scanner(System.in);

    public int checkId(String id){
        for (int i=0;i<studentsList.size();i++){
            if (id.equals(studentsList.get(i).getId())){
                return i;
            }
        }
        return -1;
    }

    public void add(Student student){
        if (checkId(student.getId())>=0){
            System.out.println("Hoc sinh nay da co");
        }else {
            studentsList.add(student);
            System.out.println("Da update");
        }
    }

    public static void menuEdit(){
        System.out.println("1.Sua id");
        System.out.println("2.Sua ten");
        System.out.println("3.Sua tuoi");
        System.out.println("4.Sua dia chi");
        System.out.println("5.Sua diem trung binh");
        System.out.println("0.Thoat");
    }

    public void edit(String id){
        var index = checkId(id);
        if (index >=0){
            menuEdit();
            while (true){
                System.out.println("Lua chon:");
                String chose=sc.nextLine();
                var student = studentsList.get(index);
                switch (chose){
                    case "1":
                        System.out.println("Sua id");
                        student.setId(sc.nextLine());
                        break;
                    case "2":
                        System.out.println("Sua ten");
                        student.setName(sc.nextLine());
                        break;
                    case "3":
                        System.out.println("Sua tuoi");
                        student.setAge(Integer.parseInt(sc.nextLine()));
                        break;
                    case "4":
                        System.out.println("Sua dia chi");
                        student.setAddress(sc.nextLine());
                        break;
                    case "5":
                        System.out.println("Sua diem trung binh");
                        student.setGpa(Float.parseFloat(sc.nextLine()));
                        break;
                    case "0":
                       System.exit(0);
                        break;
                }
            }
        }
        System.out.println("Khong co hoc sinh nay");
    }

    public void delete(String id){
        var index = checkId(id);
        if (index >=0){
          studentsList.remove(index);
            System.out.println("Update thanh cong");
        }else System.out.println("Khong co hoc sinh nay");
    }

    public void sortGpa(){
        studentsList.sort(this);
        System.out.println("Sap xep theo diem");
        for(Student st : studentsList){
            System.out.println(st.toString());
        }
    }

    public void sortName(){
        studentsList.sort(Student::compareTo);
        System.out.println("Sap xep theo ten");
        for(Student st : studentsList){
            System.out.println(st.toString());
        }
    }

    public void showName(String name){
        boolean check=false;
        for (int i=0;i<studentsList.size();i++){
            if (name.equals(studentsList.get(i).getName())){
                System.out.println(studentsList.get(i).toString());
                check=true;
                break;
            }
        }
        if (!check){
            System.out.println("Khong tim thay");
        }
    }

    public void display(){
        for (int i=0;i<studentsList.size();i++){
            System.out.println(studentsList.get(i).toString());
        }
    }
    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student1.getGpa(), student2.getGpa());
    }
}
