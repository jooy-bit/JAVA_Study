package test;

public abstract class Product {
    protected int price;
    protected String prdName;
    public abstract String sell(Object obj);
    
    @Override
    public String toString() {
        return "price=" + price + ", prdName=" + prdName ;
    }

    public Product(int price, String prdName) {
        this.price = price;
        this.prdName = prdName;
    }
    public int getPrice() {
        return price;
    }
    public String getPrdName() {
        return prdName;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }
    
    
}
