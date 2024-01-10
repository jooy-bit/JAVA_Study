package object.day8;

import object.day7.Shape;
import object.day7.Triangle;

public class B14ObjectTest {
    public static void main(String[] args) {
        System.out.println();
        Shape sh2 =new Shape("아직모름", 25, 20);
        // Shape diamond = new Diamond();
        // Shape square = new Square();
        Shape triangle = new Triangle("삼각형", 20, 30, 65);

        System.out.println(sh2);
        // System.out.println(diamond);        //자식클래스 Diamond가 정의한 toString
        // System.out.println(square);         //부모 Shape이 정의한 toString
        System.out.println(triangle);       //부모 Shape가 정의한 toString / 자식이 다른 걸 적고 싶다면 재정의 필요.
    }
    

}
