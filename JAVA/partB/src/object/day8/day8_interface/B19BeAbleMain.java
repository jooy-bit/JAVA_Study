package object.day8.day8_interface;

import object.day8.day8_interface.beable.Ai;
import object.day8.day8_interface.beable.BeAble;
import object.day8.day8_interface.beable.Cookable;
import object.day8.day8_interface.beable.Dog;
import object.day8.day8_interface.beable.Human;
import object.day8.day8_interface.beable.Runnable;
import object.day8.day8_interface.beable.Thinkable;

public class B19BeAbleMain {
    public static void main(String[] args) {
        Thinkable th1 =new Ai();
         Ai ai = (Ai) th1;    ai.setOp('*');
        Thinkable th2 =new Human();
        // Thinkable th3 =new Dog();

        Runnable run1 = new Human();
        Runnable run2 = new Dog();
        // Readable run3 = new Ai();

        Cookable cook = new Human();

        BeAble[] beAbles = new BeAble[3];
        beAbles[0] =th1;
        beAbles[1] =th2;
        beAbles[2] =run2;

        System.out.println("beable 테스트");
        for(BeAble able : beAbles){ System.out.println(able.beAble());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (able instanceof Thinkable) {
                Thinkable temp = (Thinkable) able;
                System.out.println(able.getClass().getName()+ "(은/는/이)가 계산합니다");
        //다운캐스팅
                char op =temp instanceof Ai ? ((Ai)temp).getOp(): '+';
                System.out.println("\t 연산 : "+ op);
                System.out.println("계산해주세요 --"+temp.calculate(2024,3));    
            }else{
                
                System.out.println(able.getClass().getName()+"은 계산 못합니다");

            }

        }
        Thinkable[] thinks =new Thinkable[2];

        //결론 : 업캐스팅 다운캐스팅 목적은 상속과 같은 방식으로 사용 
        // 업캐스팅은 다형성/ 업캐스팅 타입이 갖는 메소드만 실행
        // 다운캐스팅은 업캐스팅 타입이 갖는 추상메소드 외 메소드 실행하기 위함
    }
    
}
