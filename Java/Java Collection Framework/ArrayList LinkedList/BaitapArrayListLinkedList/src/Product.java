public class Product implements Comparable<Product> {
    private String name;
    private int pride;
    private int id;

    public Product() {
    }

    public Product(String name, int pride, int id) {
        this.name = name;
        this.pride = pride;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPride() {
        return pride;
    }

    public void setPride(int pride) {
        this.pride = pride;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SP: " + name + " pride: " + pride + " id: " + id;
    }

    @Override
    public int compareTo(Product product) {
        return this.getName().compareTo(product.getName());
    }
}
