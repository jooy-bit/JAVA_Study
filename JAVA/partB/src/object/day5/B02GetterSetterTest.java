package object.day5;

import java.util.Arrays;

public class B02GetterSetterTest {
    
    public static void main(String[] args) {
        MyClass2 momo = new MyClass2();
        System.out.println("MyClass2의 field1 값: "+momo.getField1());
        momo.setField1("나는 모모!!");
        System.out.println("MyClass2의 field1 값 ( 변경 후 ): "+momo.getField1());
        String message ="WelCome!";
        momo.setField1(message);
        System.out.println("MyClass2의 field1 값 ( 변경 후 ): "+momo.getField1());
        


        System.out.println("MyClass2의 field2 값: "+momo.getField2());
        momo.setField2(999);
        System.out.println("MyClass2의 field2 값 ( 변경 후 ): "+momo.getField2());

        System.out.println("MyClass3의 field1 값: "+momo.getField3());
        momo.setField3(7);
        System.out.println("MyClass2의 field1 값 ( 변경 후 ): "+momo.getField3());


    }

}
