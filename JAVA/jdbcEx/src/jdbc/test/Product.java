package jdbc.test;

public abstract class Product {
    protected String prdName;
    protected int price;

    public abstract String sell(Object obj);

    @Override
    public String toString() {
        return "prdName=" + prdName + ", price=" + price;
    }
    
}//class
