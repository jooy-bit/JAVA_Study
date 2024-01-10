package object.day8.day8_interface;

public class B16MyClassMain {
    public static void main(String[] args) {
        // InterfaceA ifa = new InterfaceA(); //인터페이스는 객체 생성 못함. 단, 익명 내부 타입으로 정의 가능
        //구현클래스로 객체 생성
        MyClassA mya = new MyClassA();

        //업캐스팅 가능
        InterfaceA ifa = new MyClassA();
    
        //다운캐스팅 가능
        MyClassA temp = (MyClassA)ifa;

        System.out.println("참조타입 변수와 상관없이 똑같이 실행됩니다.");
        mya.methodA();
        ifa.methodA();
    }

}
