package object.day8.day8_interface;

public class B17MyBlassMain {
    public static void main(String[] args) {
        MyClassB myb =new MyClassB();
        //다중 구현 클래스인 MyClassB는 두 가지 업캐스팅 가능
        InterfaceX ifx = new MyClassB();
        InterfaceA ifa = new MyClassB();
        myb.methodA();
        ifa.methodA();
        // ifx.methodX();
        //오류 : methodA는 InterfaceA의 추상메소드
        //다른 인터페이스 참조 타입으로는 실행 못함.

        ifx.methodX();
        // ifa.methodX(); //오류 : methodX는 InterfaceX의 추상메소드
    
        InterfaceX ix =(InterfaceX) ifa;
        ix.methodX();
    }

}
