import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLSP {
//    private static final String FILENAME = "QLSP.txt";
    public static ArrayList<Sp> list=new ArrayList<>();
//    public static File file = new File(FILENAME);

//    public static int id() {
//        int index = 0;
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            Scanner scanner = new Scanner(file);
//            String line;
//            while (scanner.hasNextLine()) {
//                line = scanner.nextLine();
//                String[] str = line.split(",");
//                index = Integer.parseInt(str[0]) + 1;
//            }
//            scanner.close();
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return index;
//    }

    public void addSp(Sp sp) {
//        if (checkName(sp.getName())) {
//            System.out.println("San pham nay da co");
//        } else {
//            int id = id();
//            sp.setId(id);
            list.add(sp);
//            try {
                IOBanari.writeProductToFileText(list);
//                if (!file.exists()) {
//                    file.createNewFile();
//                }
//                String str = sp.toString();
//                FileWriter fileWriter = new FileWriter(file, true);
//                fileWriter.write(str);
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

//    public String display() {
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            Scanner scanner = new Scanner(file);
//            StringBuilder str = new StringBuilder();
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                str.append(line).append("\n");
//            }
//            scanner.close();
//            return str.toString();
//        } catch (Exception e) {
//            e.getStackTrace();
//            return null;
//        }
//    }

//    public boolean checkName(String name) {
//        boolean check = false;
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] str = line.split(",");
//                if (str[1].equals(name)) {
//                    System.out.println(line);
//                    check = true;
//                    break;
//                }
//            }
//            scanner.close();
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return check;
//    }
//
//    public void delete(String name) {
//        if (!checkName(name)) {
//            System.out.println("Khong co san pham nay");
//        } else {
//            StringBuilder old= new StringBuilder();
//            try {
//                Scanner scanner = new Scanner(file);
//                while (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
//                    String[] str = line.split(",");
//                    if (!str[1].equals(name)) {
//                        old.append(line).append("\n");
//                    }
//                }
//                Writer fileWriter = new FileWriter(file);
//                fileWriter.write(old.toString());
//                scanner.close();
//                fileWriter.close();
//            } catch (Exception e) {
//                e.getStackTrace();
//            }
//        }
//    }

}

