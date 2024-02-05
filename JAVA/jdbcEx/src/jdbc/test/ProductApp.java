package jdbc.test;

public class ProductApp {
    public static void main(String[] args) {
        Product[] cart = new Product[10];
        cart[0] = new Bike("MTB", 123000, 25);
        cart[3] = new Bike("삼천리", 99000, 15);
        cart[1] = new Electronics(35000, "USB");
        cart[5] = new Electronics(527000, "스마트TV");
        cart[7] = new Electronics(2250000, "lg냉장고");
    }
}
