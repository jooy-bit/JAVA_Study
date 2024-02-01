package koreait.lesson;
//한주영
public abstract class Product {
    protected int price;
    //[1]
    protected String prdName;
    //[2]
    public abstract String produce(Object obj);
    @Override
    public String toString() {
        return "price=" + price + ", prdName=" + prdName ;
    }
    
}
