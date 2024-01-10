
package object.day6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B05ConstructorTest {

    public static void main(String[] args) {
        MyClass4 my = new MyClass4();
        System.out.println("\tfield2: "+my.getField2());

        MyClass4 my1 = new MyClass4(999);        
        MyClass4 my2 = new MyClass4("Hello");
        MyClass4 my3 = new MyClass4("java",222);
        MyClass4 my4 = new MyClass4("Lucky",1234,new double[3]);

        System.out.println("인자 1개 커스텀 생산자 실행");
        System.out.println("\tmy1 field2: "+my1.getField2());
        System.out.println("\tmy2 field1: "+my2.getField1());
        
        System.out.println("\n\n인자 2개 커스텀 생산자 실행");
        System.out.println("\tmy3 field1: "+my3.getField1());
        System.out.println("\tmy3 field2: "+my3.getField2());
    
        System.out.println("\n\n인자 2개 커스텀 생산자 실행");
        System.out.println("\tmy4 field1: "+my3.getField1());
        System.out.println("\tmy4 field2: "+my3.getField2());
        System.out.println("\tmy4 field3: "+my3.getField3());
        System.out.println("\tmy4 field3: "+Arrays.toString(my4.getField3()));

        //기본생성자와 setter가 없는 MyClass5 객체가 
        MyClass5 my5 = new MyClass5("Languege",1111, new double[3]);
        // MyClass5 my6 = new MyClass5()); //오류 기본생성자가 없는 클래스
        System.out.println("MyClass5 객체 확인");
        System.out.println("\tmy5 field1: "+my5.getField1());
        System.out.println("\tmy5 field2: "+my5.getField2());
        System.out.println("\tmy5 field3: "+my5.getField3());


        System.out.println("MyClass3과 MyClass5차이");
        MyClass3 test =new MyClass3();
        test.setField1("python");
        test.setField2(9999);
        test.serField3(new double[]{1.2,34.56,78.90});
        //기본생성자는 set 메소드로 직접 값을 초기화하는 것이 조금 불편하다
        //            초기화를 위해서 커스텀 생성자가 좋다


        // :'MyCalss3과 같이 생성자 메소드가 직접 정의된 것이 없으면 기본생성자만 사용 가능
        //   MyClass5와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면 기본 생성자는 생략하고 사용 못함
                    //사용을 원할 시 직접 정의해야한다. ==> public MyClass5(){    }
    

    }
}
