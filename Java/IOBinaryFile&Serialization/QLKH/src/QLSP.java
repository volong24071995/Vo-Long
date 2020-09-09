import java.io.*;
import java.util.ArrayList;

public class QLSP {
    private static final String FILENAME = "QLSP.txt";
    public static File file = new File(FILENAME);

     public static int id(){
         int index=0;
         try {
             FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             String line;
             while ((line = bufferedReader.readLine()) != null) {
                 String[] str = line.split(",");
                 index=Integer.parseInt(str[0])+1;
                 }
         } catch (Exception e) {
             e.getStackTrace();
         }
         return index;
    }

    public void addSp(Sp sp) {
        if (checkName(sp.getName())) {
            System.out.println("San pham nay da co");
        } else {
            int id=id();
            sp.setId(id);
            try {
                String str = sp.toString();
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.append(str);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String display() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String str = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (str == null) {
                    str = line;
                } else {
                    str += "\n" + line;
                }
            }
            return str;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public boolean checkName(String name) {
        boolean check = false;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str[1].equals(name)) {
                    String text="";
                    for (int i=0;i<str.length;i++){
                        text+=str[i]+" ";
                    }
                    System.out.println(text);
                    check = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return check;
    }
}
