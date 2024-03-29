package koreait.solution;



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
}
