import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager implements Comparator<Product> {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Product> listProduct = new ArrayList<>();

    public void add(Product product) {
        if (checkId(product.getId()) >= 0) {
            System.out.println("Da ton tai");
        } else listProduct.add(product);
    }

    public static void menuEdit() {
        System.out.println("1.Sua ten: ");
        System.out.println("2.Sua gia:");
        System.out.println("3.Sua id");
        System.out.println("4.Thoat");
    }

    public void edit(int id) {
        if (checkId(id) >= 0) {
            menuEdit();
            String chose;
            boolean check = true;
            int index = checkId(id);
            while (check) {
                System.out.println("Lua chon:");
                chose = scanner.nextLine();
                switch (chose) {
                    case "1" -> {
                        System.out.println("Sua ten: ");
                        listProduct.get(index).setName(scanner.nextLine());
                    }
                    case "2" -> {
                        System.out.println("Sua gia: ");
                        listProduct.get(index).setPride(Integer.parseInt(scanner.nextLine()));
                    }
                    case "3" -> {
                        System.out.println("Sua id: ");
                        listProduct.get(index).setId(Integer.parseInt(scanner.nextLine()));
                    }
                    case "4" -> {
                        System.out.println("Update xong");
                        check = false;
                    }
                }
            }
        }
    }

    public void delete(int id) {
        if (checkId(id) >= 0) {
            listProduct.remove(checkId(id));
        } else System.out.println("Khong co id: " + id);
    }

    public void display() {
        listProduct.stream().map(Product::toString).forEach(System.out::println);
    }

    public void search(int id) {
        if (checkId(id) >= 0) {
            System.out.println(listProduct.get(checkId(id)).toString());
        } else System.out.println("Khong co id: " + id);
    }

    public void sort() {
        listProduct.sort(this);
        System.out.println("So sanh theo gia:");
        for(Product st : listProduct){
            System.out.println(st.toString());
        }
    }

    public int checkId(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int compare(Product product1, Product product2) {
        return Integer.compare(product1.getPride(), product2.getPride());
    }
}
