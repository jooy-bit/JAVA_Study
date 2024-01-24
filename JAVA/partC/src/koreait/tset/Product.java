package koreait.tset;

public abstract class Product{
    protected String prdName;
    
    public abstract String sell (Object odj);
    
    public String toSring(){
        return "Product [prdName= "+prdName+ " ]";
    }
}