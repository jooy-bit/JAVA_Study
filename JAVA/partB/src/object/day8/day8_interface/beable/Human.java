package object.day8.day8_interface.beable;

import java.io.IOException;
import java.nio.CharBuffer;

public class Human implements Thinkable, Cookable, Runnable{

    @Override
    public int calculate(int a, int b) {
        int result =0;
        if(a>=99999&&b>=99999){
            System.out.println(" 암산 할 수 없습니다.");
            result = -999999;
        }else{
            System.out.println("암산 가능합니다");
            result =a+b;
        }
        return 0;
    }

    @Override
    public void think() {
        System.out.println("인간은 창의적으로 생각할 수 있습니다 \n"
                            +"단 데이터가 너무 많으면 포기합니다");
        
    }

    @Override
    public String beAble() {
        return "생각하고 요리하고 달리기도 합니다";
    }

    @Override
    public void cook(String material) {
        System.out.println(material + "을 이용해 요리합니다");        
    }

   

    @Override
    public String run(int speed){
        return "사람은" + speed + "Km/h로 달립니다";
    }
    
    
}
