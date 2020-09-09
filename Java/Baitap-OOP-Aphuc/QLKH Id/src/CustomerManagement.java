import java.util.HashMap;

public class CustomerManagement {
    private final HashMap<Integer, Customer> list = new HashMap<>();
    private static int id = 0;
    private static int lengthName = 4;
    private static int lengthAddress = 7;
    private static int lengthEmail = 5;
    public  static int lengthGender=6;

    public boolean checkInformation(Customer customer) {
        var email = customer.getEmail();
        var phoneNumber = customer.getPhoneNumber();
        return list.containsValue(email) && list.containsValue(phoneNumber);
    }

    public void addCustomer(Customer customer) {
        if (checkInformation(customer)) {
            System.out.println("Khach hang da ton tai.He thong vua update thong tin");
        } else {
            id++;
            customer.setId(id);
            System.out.println("Ban vua them moi khach hang " + customer.getName() + " thanh cong ");
            list.put(id, customer);
            maxLength(customer);
        }
    }

    public void maxLength(Customer customer) {
        var length = customer.getName().length();
        if (length > lengthName) {
            lengthName = length;
        }
        var length1 = customer.getAddress().length();
        if (length1 > lengthAddress) {
            lengthAddress = length1;
        }
        var length2 = customer.getEmail().length();
        if (length2 > lengthEmail) {
            lengthEmail = length2;
        }
    }

    public String getStringByInt(int i) {
        return " ".repeat(Math.max(0, i));
    }

    public String getString(int k) {
        return "-".repeat(Math.max(0, k));
    }

    public int checkId(int id) {
        if (list.containsKey(id)) {
            return id;
        }
        return -1;
    }

    public void searchNotHasOdder(int id) {
        int index = checkId(id);
        if (index > 0) {
            System.out.println(list.get(id).toString());
        } else System.out.println("khong co khach hang");
    }

    public void searchHasOdder(int id) {
        int index = checkId(id);
        if (index > 0) {
            System.out.println(list.get(id).toString() + ", tong don hang " + list.get(id).getTotalOder());
        } else System.out.println("khong co khach hang");
    }

    public void addOrder(int id) {
        int index = checkId(id);
        if (index > 0) {
            list.get(id).setTotalOder(list.get(id).getTotalOder() + 1);
            System.out.print(" tong don hang " + list.get(id).getTotalOder());
        } else System.out.println("khong co khach hang");
    }
    public void displayData() {
        System.out.println(getString(55+lengthAddress+lengthEmail+lengthName+lengthGender));
        System.out.print(" Id"+getStringByInt(3)+"|");
        System.out.print(" Name"+getStringByInt(lengthName-1)+"|");
        System.out.print(" Gender"+getStringByInt(3)+"|");
        System.out.print(" Address"+getStringByInt(lengthAddress-4)+"|");
        System.out.print(" Email"+getStringByInt(lengthEmail-2)+"|");
        System.out.print(" Phone"+getStringByInt(8)+"|");
        System.out.print(" Total Odder");
        System.out.println();
        for (Customer customer : list.values()) {
            System.out.print(" " + customer.getId() + getStringByInt(4) + "|");
            var name = customer.getName();
            System.out.print(" " + name + getStringByInt(lengthName + 3 - name.length()) + "|");
            var gender = customer.isGender();
            System.out.print(" " + gender + getStringByInt(lengthGender+3- gender.length()) + "|");
            var address = customer.getAddress();
            System.out.print(" " + address + getStringByInt(lengthAddress + 3 - address.length()) + "|");
            var email = customer.getEmail();
            System.out.print(" " + email + getStringByInt(lengthEmail + 3 - email.length()) + "|");
            System.out.print(" " + customer.getPhoneNumber() + getStringByInt(3) + "|");
            System.out.print(" " + customer.getTotalOder());
            System.out.println();
        }
    }
}


