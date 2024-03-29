package test;

public class ProductApp {
    public static void main(String[] args) {
        Product[] cart = new Product[10];
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[1] = new ELectronics(35000, "USB");
        cart[5] = new ELectronics(527000, "스마트TV");
        cart[7] = new ELectronics(2250000, "lg냉장고");

        ELectronics tv =null;
        tv = (ELectronics) cart[5]; //카트가 product의 자식이니까.. 다운 캐스팅
        tv.setKwh(1.9);//+++++
        System.out.println(tv.power());

        for (Product p : cart) {
            if (p!=null&&p.price>=100000) {
                System.out.println(p);
            }
        }
        for (Product p : cart) {
            if (p!=null&& p instanceof Bike) {
                Bike bike = (Bike) p;//+++++
                System.out.println(bike.ride());
            }
        }
System.out.println("------------------------------------------");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i]!=null&& cart[i] instanceof Bike) {
                Bike bike = (Bike) cart[i];//+++++
                System.out.println(bike.ride());
            }
        }
    }
}
