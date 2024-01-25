package koreait.solution;

public abstract class Product {
    protected int price;
    protected String prdName;   // 1 - [1]
    public abstract String sell(Object object); // 1 - [2]    
    @Override
    public String toString() {
        return "prdName=" + prdName + ", price=" + price;
    }

    
}

