package koreait.solution;

public class ProductApp {
    public static void main(String[] args) {
        //2-[1]
        Product[] cart = new Product[10];
        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[1] = new ELectronics(35000, "USB");
        cart[5] = new ELectronics(527000, "스마트TV");
        cart[7] = new ELectronics(2250000, "lg냉장고");

        //2-[2]
        //현재 부모타입으로 참조하는 것을 자식타입으로 변경 (다운캐스팅)
        ELectronics tv =null;
        //다운캐스팅은 안전하게 타입체크
        if (cart[5]instanceof ELectronics) {
            tv =(ELectronics) cart[5];        
            tv.setKwh(0.9);
            System.out.println(tv.power());
        }else {System.out.println("Electronics 타입으로 변경 불가");}
        

        //2-[3]★★★★★
        //->반복문 실행시 반드시 null이 아닌것만 하도록 합니다.
        //->null이면 메소드 실행 예외 발생 NullPointerException
        for (Product p : cart) {
            if (p !=null && p.price>=100000) 
                System.out.println(p);//p.toString toString생략
        }

        //2-[4]
        //현재 부모타입으로 참조하는 것을 자식타입으로 변경 (다운캐스팅)
        for (Product p : cart) {
            if (p !=null && p instanceof Bike) {
                Bike bike = (Bike) p;
                System.out.println(bike.ride());
            }
        }

        Bike bike = null;
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] !=null && cart[i] instanceof Bike) {
                bike = (Bike) cart[i];
                System.out.println(bike.ride());
            }
            
        }

        //2-[5]
        String result =cart[3].sell(20);
        System.out.println(result);

        //2-[6]
        System.out.println(cart[5].sell("사운드바"));
    }
}

/**
 * 자바 교재 204 page
 * 라이브러리 클래스 : product, bike, Electronics 
 * 실행 클래스 : main 메소드를 포함하여 프로그램을 실행, main은 반드시 static, main 메소드를 위한 객체를 먼저 생성
 * 
 * 설명 예시 : Bike클래스의 sell 메소드 Object 인자값은 외부에서 줍니다
 *              여기서 외부는 이 메소드를 사용하는 main 또는 다른 클래스를 말합니다
 *              라이브러리 클래스의 특히 인스턴스 필드값은 실행될 때 결정됩니다
 */