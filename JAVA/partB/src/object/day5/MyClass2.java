package object.day5;

import java.util.Arrays;

public class MyClass2 {
    private String field1;
    private int field2;
    private double[] field3; //참조값 저장 변수

    // //static 필드-클래스 이름으로 사용
    // private static int field5;
    // private static final int FIELD4=999;
    
    //필드값을 가져오는 메소드
    public String getField1(){
        return field1;
    }

    public int getField2(){
        return field2;
    }

    public double[] getField3(){
        return field3;
    }                           //참조값 리턴

    //필드값을 저장하는 메소드
    public void setField1(String f1){
        field1= f1;
    }

    public void setField2(int f2){
        field2= f2;
    }

    public void setField3(double[] f3){
        field3 = f3;
    }
   
    //모든 인스턴스 필드 값을 출력해주는 메소드
    public void printData(){
        System.out.println("field1 = "+field1+",field2= "+field2+",field3= "+field3+","+ Arrays.toString(field3));
    }

}
