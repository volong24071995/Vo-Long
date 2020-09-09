import java.util.Scanner;
import java.util.regex.Pattern;

public class Screen {
    static Scanner scanner = new Scanner(System.in);
    private static final CustomerManagement customerManagement = new CustomerManagement();

    public static void menu() {
        System.out.println("Menu");
        System.out.println("Bấm 1 để nhập khách hang");
        System.out.println("Bấm 2 để tim kiem khach hang");
        System.out.println("Bam 3 để in thong khach hang");
        System.out.println("Bam 4 để in toan bo danh sach khach hang");
        System.out.println("Bam 5 để tang so don hang cho khach");
        System.out.println("Bam 0 để thoat");
    }

    public static void addNewCustomer() {
        Customer customer = new Customer();
        System.out.println("Nhập tên:");
        customer.setName(scanner.nextLine());
        System.out.println("Nhập dia chi:");
        customer.setAddress(scanner.nextLine());
        System.out.println("Nhap email:");
        customer.setEmail(checkEmail());
        System.out.println("Nhap sdt:");
        customer.setPhoneNumber(checkPhone());
        System.out.println("Nhap gioi tinh:");
        customer.setGender(scanner.nextLine());
        customerManagement.addCustomer(customer);
    }

    public static void searchCustomer() {
        System.out.println("Nhap id khach hang:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Hẹ thong dang tim kiem");
        System.out.println("Ket qua:");
        customerManagement.searchNotHasOdder(id);
    }

    public static void searchCustomerHasOder() {
        System.out.println("Nhap id khach hang:");
        int id = Integer.parseInt(scanner.nextLine());
        customerManagement.searchHasOdder(id);
    }

    public static void displayAll() {
        customerManagement.displayData();
    }

    public static void addOdder() {
        System.out.println("Nhap id khach hang:");
        int id = Integer.parseInt(scanner.nextLine());
        customerManagement.addOrder(id);
    }


    public static void main(String[] args) {
        Screen.menu();
        String chose;
        while (true) {
            System.out.println();
            System.out.println("Lua chon:");
            chose = scanner.nextLine();
            switch (chose) {
                case "1" -> Screen.addNewCustomer();
                case "2" -> Screen.searchCustomer();
                case "3" -> Screen.searchCustomerHasOder();
                case "4" -> Screen.displayAll();
                case "5" -> Screen.addOdder();
                case "0" -> {
                    System.out.println("He thong Quan ly khach hang vua shutdown.");
                    System.exit(0);
                }
                default -> System.out.println("Nhap lai");
            }
        }
    }

    public static String checkEmail() {
        String email = scanner.nextLine();
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//        "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        while (!Pattern.matches(EMAIL_PATTERN, email)) {
            System.out.println("Email khong dung vui long nhap lai: ");
            email = scanner.nextLine();
        }
        return email;
    }

    public static String checkPhone() {
        boolean flag;
        String input = scanner.nextLine();
        String phonePattern = "\\d{3}\\d{2}\\d{5}";
        flag = input.matches(phonePattern);
        while (!flag){
            System.out.println("Vui long nhap lai so dien thoai");
            input = scanner.nextLine();
            flag = input.matches(phonePattern);
        }
        return input;
    }
}
