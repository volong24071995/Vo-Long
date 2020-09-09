
import java.util.Date;
import java.util.Scanner;

public class NotesManagement {
    public static final String KHÔNG_TIM_THẤY_NOTE = "Không tìm thấy note";
    public static final String ĐÃ_UPDATE_THÀNH_CÔNG = "Đã update thành công";
    public static final String SỬA_TIÊU_ĐỀ = "Sửa tiêu đề:";
    public static final String SỬA_NỘI_DUNG = "Sửa nội dung:";
    public static final String SỬA_DANH_SÁCH = "Sửa danh sách:";
    private Note[] notebook = new Note[128];
    private static int count = 0;
    Scanner scanner = new Scanner(System.in);

    public void addNote(Note note) {
        if (isCheckName(note.getName())) {
            System.out.println("Đã có ghi chú");
        } else {
            var length = notebook.length;
            if (count > length) {
                System.out.println("Ghi chú đã đầy không thêm được nữa");
            } else {
                for (int i = 0; i < length; i++) {
                    if (notebook[i] == null) {
                        notebook[i] = note;
                        count++;
                        break;
                    }
                }
                System.out.println(ĐÃ_UPDATE_THÀNH_CÔNG+"\n");
            }
        }
    }

    public static void menuEdit() {
        System.out.println("1."+ SỬA_TIÊU_ĐỀ);
        System.out.println("2."+SỬA_NỘI_DUNG);
        System.out.println("3."+SỬA_DANH_SÁCH);
        System.out.println("0.Thoát");
    }

    public void editNote(String name) {
        if (isCheckName(name)) {
            for (int i = 0; i < count; i++) {
                var note = notebook[i];
                if (name.equals(note.getName())) {
                    System.out.println(note.toString());
                    menuEdit();
                    boolean check = true;
                    while (check) {
                        System.out.println("Nhập lựa chọn:");
                        var scnl = scanner.nextLine();
                        String chose = scnl;
                        switch (chose) {
                            case "1" -> {
                                editTitle(note, scnl);
                            }
                            case "2" -> {
                                editContent(note, scnl);
                            }
                            case "3" -> {
                                editList(note);
                            }
                            case "0" -> check = false;
                        }
                    }
                    System.out.println(ĐÃ_UPDATE_THÀNH_CÔNG);
                    break;
                }
            }
        } else System.out.println(KHÔNG_TIM_THẤY_NOTE);
    }

    private void editTitle(Note note, String scnl) {
        System.out.println(SỬA_TIÊU_ĐỀ);
        note.setName(scnl);
        note.setDateEdit(new Date());
    }

    private void editContent(Note note, String scnl) {
        System.out.println(SỬA_NỘI_DUNG);
        note.setContent(scnl);
        note.setDateEdit(new Date());
    }

    private void editList(Note note) {
        System.out.println(SỬA_DANH_SÁCH);
        System.out.println(note.displayTasks());
        System.out.println("Nhập vi tri cần sửa");
        int index = check();
        note.editTask(index);
        note.setDateEdit(new Date());
    }

    public static void menuDelete() {
        System.out.println("Bạn có xóa không");
        System.out.println("Bấm C để đồng ý");
        System.out.println("Bấm K để không");
    }

    public void deleteNote(String name) {
        if (isCheckName(name)) {
            for (int i = 0; i < count; i++) {
                var note = notebook[i];
                if (name.equals(note.getName())) {
                    System.out.println(note.toString());
                    menuDelete();
                    System.out.println("Lựa chon");
                    String chose = scanner.nextLine();
                    switch (chose) {
                        case "C":
                            for (int j = i; j < count - 1; j++) {
                                notebook[j] = notebook[j + 1];
                            }
                            notebook[count - 1] = null;
                            count--;
                            System.out.println("Đã xóa thành công");
                            break;
                        case "K":
                            break;
                    }
                }
                break;
            }
        } else System.out.println(KHÔNG_TIM_THẤY_NOTE);
    }

    public String searchNote(String name) {
        String text = "";
        if (isCheckName(name)) {
            for (int i = 0; i < count; i++) {
                var note = notebook[i];
                if (name.equals(note.getName())) {
                    text += note.toString();
                    break;
                }
            }
        } else System.out.println(KHÔNG_TIM_THẤY_NOTE);
        return text;
    }

    public boolean isCheckName(String name) {
        for (int i = 0; i < count; i++) {
            var note = notebook[i];
            if (note == null) {
                return false;
            } else if (name.equals(note.getName())) {
                return true;
            }
        }
        return false;
    }

    public String displayMenu() {
        int countMenu = 0;
        String text = "";
        for (int i = count - 1; i >= 0; i--) {
            if (countMenu < 3) {
                var note = notebook[i];
                if (note != null) {
                    text += (countMenu + 1) + ". " + note.toString() + "\n";
                    countMenu++;
                }
            } else break;
        }
        return text;
    }

    public String displayAll() {
        String text = "";
        for (int i = 0; i < count; i++) {
            var note = notebook[i];
            if (note == null) {
                break;
            } else text += note.toString() + "\n";
        }
        return text;
    }
    //Ham validate
    public static int check() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = false;
        while (!check) {
            try {
                n = sc.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("ban nhap sai kieu du lieu \n moi nhap lai : ");
                sc.nextLine();
            }
        }
        return n;
    }
}
