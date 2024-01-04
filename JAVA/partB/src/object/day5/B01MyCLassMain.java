package object.day5;

// import java.sql.Array;
import java.util.Arrays;

public class B01MyCLassMain {
    public static void main(String[] args) {
        //정의된 클래스 MyClass1으로 객체를 만든다. - new 연상 이용
        MyClass1 my1 = new MyClass1();
        //객체란 데이터 덩어리. new 연산으로 MyClass1 객체를 저장할 메모리 확보
                                        // MyClass1()는 생성자 메소드. 무조건 클래스 이름과 같아
                                                      //메모리에 저장공간을 확보하면 동시 실행해

    System.out.println("my1.field1: "+ my1.field1);//String
    System.out.println("my1.field2: "+ my1.field2);//Int
    System.out.println("my1.field3: "+ my1.field3);//Double
    System.out.println("my1.field3 배열 크기: "+ my1.field3.length);//Double
    System.out.println("my1.field3 배열 요소 값: "+ Arrays.toString(my1.field3));//Double


    /*  출력 값
     *  my1.field1: null
     *  my1.field2: 0   
     *  my1.field3: null */
    
    
    my1.field1= "Hi momo";
    my1.field2= 999;
    my1.field3= new double[5];
    
    System.out.println("\nmy1.field1: "+my1.field1);//String
    System.out.println("my1.field2: "+my1.field2);//Int
    System.out.println("my1.field3: "+my1.field3);//Double
    
    MyClass1 my2 = new MyClass1();
    System.out.println("my2 해시코드: "+my2.hashCode());
    my2.field1= "점심먹으러 갑시다.";
    my2.field2= 12345;
    my2.field3= new double[]{34.12,23.99,6.78};
    System.out.println("my2 해시코드: "+my2.hashCode());

    // MyClass1 err = new MyClass2();
        //error: 객체 타입과 변수 타입이 불일치
    
    
    //private : 사적인, 개인적인, MyClass2 클래스 외에는 사용할 수 없는 필드.
    // System.out.println("\nmy1.field1: "+my1.field1);//String
    // System.out.println("my1.field2: "+my1.field2);//Int
    // System.out.println("my1.field3: "+my1.field3);//Double
    




    }
}