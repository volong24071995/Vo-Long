public class Table {
    private static Table[] tables;
    private int id;
    private Product[] product=new Product[4];
    private long total;
    boolean status=false;
    private int i;

    public Table() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product[] getProduct(){
        return product;
    }

    public void setProduct(Product product){
        if (i<4){
            this.product[this.i]=product;
            i++;
        }
    }
}
