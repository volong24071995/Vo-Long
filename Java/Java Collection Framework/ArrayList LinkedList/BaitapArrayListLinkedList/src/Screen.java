import java.util.Scanner;

public class Screen {
    static ProductManager productManager = new ProductManager();
    static Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        Product product = new Product();
        System.out.println("Nhap ten:");
        product.setName(scanner.nextLine());
        System.out.println("Nhap pride:");
        product.setPride(check());
        System.out.println("Nhap id:");
        product.setId(check());
        productManager.add(product);
    }

    public static void editProduct() {
        System.out.println("Nhap id can sua");
        int id = check();
        productManager.edit(id);
    }

    public static void deleteProduct() {
        System.out.println("Nhap id can xoa");
        int id = check();
        productManager.delete(id);
    }

    public static void dispalyAll() {
        productManager.display();
    }

    public static void searchProduct() {
        System.out.println("Nhap id can tim");
        int id = check();
        productManager.search(id);
    }

    public static void sortProduct() {
        productManager.sort();
    }

    public static void menu() {
        System.out.println("1.Them");
        System.out.println("2.Sua");
        System.out.println("3.Xoa");
        System.out.println("4.Hien thi");
        System.out.println("5.Tim kiem");
        System.out.println("6.Sap xep");
        System.out.println("0.Thoat");
    }

    public static void main(String[] args) {
        menu();
        while (true) {
            System.out.println("Lua chon:");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1" -> addProduct();
                case "2" -> editProduct();
                case "3" -> deleteProduct();
                case "4" -> dispalyAll();
                case "5" -> searchProduct();
                case "6" -> sortProduct();
                case "0" -> System.exit(0);
            }
        }
    }

    //Ham validate
    public static int check() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = false;
        while (!check) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("ban nhap sai kieu du lieu \n moi nhap lai : ");
                sc.nextLine();
            }
        }
        return n;
    }
}
