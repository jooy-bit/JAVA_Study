package object.day6;

public class B06ProductMain {
    public static void main(String[] args) {
        //product 객체 4개
        Product snack = new Product("새우깡", 1200, "농심", new String[3]);
        Product drink = new Product("칠성사이다", 2200, "롯데", new String[3]);
        Product fruit = new Product("부사", 12000, "우리농원", new String[3]);
        Product icecream = new Product("투게더", 7000, "빙그레", new String[3]);
    
        //출력해봅시다.
        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);
        /*
         * object.day6.Product@2a139a55 -2a139a55: 객체 참조값
         * object.day6.Product@15db9742 -object.day6.Product 패키지이름, 클래스이름
         * object.day6.Product@6d06d69c
         * object.day6.Product@7852e922
         */
        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(icecream.getData());


        //Quiz. snack의 etc필드 배열요소 0번에 "10개 묶음" 문자열을 저장하세요.
        String[] temp= snack.getEtc();
        temp[0]="10개 묶음";
        System.out.println(snack.getEtc()[0]); //10개 묶음
        System.out.println(snack.getEtc()); //-[Ljava.lang.String;@14ae5a5

        // snack.setPrice(1000);   //set 메소드 없음 -> 없음
        // snack.price =1000;  //private -> error

        Product[] mycarts = new Product[5];     //Product 객체 배열
        mycarts[0]=drink;
        mycarts[1]=icecream;
        //mycarts[2]=drink;
        mycarts[3]=fruit;
        mycarts[4]=snack;
        System.out.println("******************마이카드*******************");
        for (int i = 0; i < mycarts.length; i++) {
            if(mycarts[i]!=null)
                System.out.println(mycarts[i].getData());//mycarts[i]가 null일 경우 메모리 할당이 안된 상태 
        }
        

    }
}
