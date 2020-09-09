public class Product {
    private Product[] products;
    private String name;
    private long pride;
    private long total;
    private long amount;

    public Product(String name, long pride) {
        this.name = name;
        this.pride = pride;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPride() {
        return pride;
    }

    public void setPride(long pride) {
        this.pride = pride;
    }

    public long getTotal() {
        this.total=this.amount*this.pride;
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }


}
