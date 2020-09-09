public class Customer{

    private String name;
    private  String address;
    private String phoneNumber;
    private String email;
    private String gender;
    private int totalOder;
    private int id=0;

    Customer(){}

    public Customer(String name, String address, String phoneNumber, String email, String gender,int id) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.totalOder = 0;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTotalOder() {
        return totalOder;
    }

    public void setTotalOder(int totalOder) {
        this.totalOder = totalOder;
    }

    @Override
    public String toString(){
        return "Id: "+id+" Name: "+name
                +" Address: "+address
                +" Phone: "+phoneNumber
                +" Email: "+email
                +" Gender: "+gender
                +" Total odder: "+totalOder;
    }
}


