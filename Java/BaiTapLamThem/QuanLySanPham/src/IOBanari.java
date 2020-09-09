import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class IOBanari {
    private static final String FILENAME = "QLSP.txt";

    public static void writeProductToFileText(ArrayList<Sp> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILENAME);
            for (Sp sp : list) {
                fileWriter.append(sp.toString());
            }
            fileWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
