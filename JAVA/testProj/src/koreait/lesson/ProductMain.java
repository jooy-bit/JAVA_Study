package koreait.lesson;
//한주영
public class ProductMain {
    public static void main(String[] args) {
        //[1]
        Product[] cart = new Product[10];
        cart[1] = new Food(5500,"카페라떼",220);
        cart[3] = new Food(2400,"불닭볶음면",150);
        cart[4] = new Food(1200,"3분카레",260);
        cart[2] = new Drink(1200,"탄산수");
        cart[5] = new Drink(5500,"맥주");
        cart[7] = new Drink(3400,"코카콜라");

        //[2]
        System.out.println("~~~~~~~~~~~~~~~~~~~2번문제~~~~~~~~~~~~~~");
        Drink drink = null;
        drink = (Drink) cart[5];
        drink.setAlcholic(false);
        System.out.println(drink.buy());

        //[3]
        System.out.println("~~~~~~~~~~~~~~~~~~~3번문제~~~~~~~~~~~~~~");

        for (Product p : cart) {
            if (p!=null&&p.price<5000) {
                System.out.println(p);
            }
        }

        //[4]
        System.out.println("~~~~~~~~~~~~~~~~~~~4번문제~~~~~~~~~~~~~~");

        for (Product p : cart) {
            if (p!=null&&p instanceof Food) {
                Food fd = (Food) p;
                System.out.println(fd.intake(60));
            }
        }

        //[5]
        System.out.println("~~~~~~~~~~~~~~~~~~~5번문제~~~~~~~~~~~~~~");

        System.out.println(cart[4].produce("청주공장"));

        //[6]
        System.out.println("~~~~~~~~~~~~~~~~~~~6번문제~~~~~~~~~~~~~~");

        System.out.println(cart[5].produce(6));

    }
}
