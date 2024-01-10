package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {
    public static void main(String[] args) {
        Cart momos_cart = new Cart();
        String[] products ={"새우깡","칠성사이다","빅토리아","비타오백","신라면블랙","식혜","빼빼로"};
        int[] prices={3000,2500,9900,12000,9800,6000,1000};
        
        momos_cart.setId("모모");
        momos_cart.setNames(products);
        momos_cart.setPrices(prices);

        Scanner sc =new Scanner(System.in);

        System.out.println("모모님의 장바구니 입니다");
        System.out.println( "\t번호\t\t상품명\t\t가격");


        for (int i = 0; i < momos_cart.getNames().length; i++) {
            System.out.println("\t"+i+"\t"+momos_cart.getNames()[i]+"\t"+momos_cart.getPrices()[i]);
        }
        System.out.println("구매할 상품 번호를 선택하십시오.선택종료는 -1입니다.");
        int sel=0;
        int[] select =new int[momos_cart.getNames().length];
        int k = 0; //select index
        while (sel!=-1&&k<select.length) {
            System.out.print("상품번호 입력 >>> ");
            sel =sc.nextInt();
            //sel의 선택범위는 productNames인덱스 범위값만
            if (sel<-1||sel>products.length-1) {
                System.out.println("없는 상품입니다. 다른 상품을 이용해주세요.");
                continue;
            }
            select[k++]=sel;
        }

        if (k==select.length){
            System.out.println("장바구니가 가득 찼습니다.");
        }
        System.out.println("선택하신 상품은 "+Arrays.toString(select));
        // System.out.println(momos_cart.getId()+" 님의 장바구니 합계는 "+ momos_cart.total_Money();    
          
        //momos_cart.settotal_Money(20000); //setter 메소드가 여기서는 필요 없습니다.
        momos_cart.total_Money(select);                                    //total_Money 메소드가 대신 값을 계산해서 저장할 것입니다.
        System.out.println(momos_cart.getId() +","+ momos_cart.getTotal_Money());
        //필요에 따라서는 기존의 setter메소드는 사용하지 않고
        //추가적인 비즈니스로직을 구현하는 메소드를 만듦. - total_Money 메소드
    }
}
