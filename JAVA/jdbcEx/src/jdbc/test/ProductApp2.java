package jdbc.test;

import jdbc.test.Bike.ELectronics;

public class ProductApp2 {
    public static void main(String[] args) {
        Product[] cart = new Product[10];
        cart[0] = new Bike(null, 0, 0);
        cart[1] = new ELectronics(4000,"ff");
    }
}
