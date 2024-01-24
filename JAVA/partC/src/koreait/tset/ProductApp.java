package koreait.tset;

import java.util.ArrayList;
import java.util.List;

import koreait.tset.Bike.Electronics;

public class ProductApp {
    public static void main(String[] args) {
       Product[] cart = new Product[10] ;
       cart[0] = new Bike(123000, "MTB", 25);
       cart[1] = new Electronics(35000,"USB");
       cart[3] = new Bike(99000, "삼천리", 15);
       cart[5] = new Electronics(527000, "스마트TV");
       cart[7] = new Electronics(2250000, "lg냉장고");
    
    //[2]
       System.out.println(cart[5].power(0.9));

    //[3]
       for (int i = 0; i < cart.length; i++) {
        if (cart[i].getPrice()>=100000) {
            System.out.println(cart[i].toSring());
        }else continue;        
       }
    //[4]
    for (int i = 0; i < cart.length; i++) {
        if (cart[i].ride(5)!=null) { System.out.println("caSt[i].ride(): "+ cart[i].ride());
    }

    //[5]
    cart[3].sell(20);


    //[6]
    cart[5].sell("사운드바");
    }
    
}
}
