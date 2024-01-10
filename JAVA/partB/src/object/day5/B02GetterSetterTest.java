package object.day5;

// import java.util.Arrays;

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



        double[] dArray =momo.getField3();
        System.out.println("MyClass3의 field1 값: "+dArray);
        System.out.println("MyClass3의 field1 값: "+momo.getField3());
        double[] tempArray ={1,2,3,4.55,67.12};
        momo.setField3(tempArray);
        System.out.println("변경된 field3 확인합니다");
        momo.printData();
        momo.setField3(new double[5]);
        System.out.println("변경된 field3 확인합니다");
        momo.printData();

        tempArray[2]=3.1415;
        System.out.println("변경된 field3 확인합니다");
        momo.printData();
        System.out.println(tempArray.toString());

        momo.setField3(tempArray);
        System.out.println("변경된 field3 확인합니다");
        momo.printData();//

    }

}
