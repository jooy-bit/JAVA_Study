package object.day6;

import java.util.Arrays;

public class Product {
    private String productNames;
    private int price;
    private String company;
    private String[] etc;
    
    //Custom 
    public Product (String productNames,int price,String company,String[] etc){
        this.productNames = productNames;
        this.price = price;
        this.company = company;
        this.etc =etc;
    }
    

    //Getter
    public String getCompany() {
        return company;
    }
    public String getProductNames() {
        return productNames;
    }
    public int getPrice() {
        return price;
    }
    public String[] getEtc() {
        return etc;
    }



}
