package basic.day5;

import java.util.Arrays;

//데이터 참조값과 관련된 테스트
public class A29ArrayVar {
    public static void main(String[] args) {
        int[] iArray = { 1, 2, 3, 4, 5 };
    double[] dArray = new double[5];
    char[] cArray = new char[5];
    cArray[0] = 'j';        
    cArray[1] = 'a';       
    cArray[2] = 'v';       
    cArray[3] = 'a';       
    cArray[4] = '!';
    
    System.out.print("\n1.  ");
    System.out.println(iArray);
    System.out.print("\n2.  ");
    System.out.println(dArray);
    System.out.print("\n3.  ");
    System.out.println(cArray);

    int[] temp;
    temp = iArray;              //iArray에 주소(참조값)을 temp변수에 저장
    System.out.print("\n4.  ");
    System.out.println(temp);
    
    temp[3]=999;
    System.out.println("temp[3]: "+temp[3]);
    System.out.println("temp 배열의 값: "+Arrays.toString(temp));
    System.out.println("iArray[3]: "+iArray[3]);


    iArray[1]=1234;
    System.out.println("temp 배열의 값: "+Arrays.toString(temp));//iArray와 temp의 참조값이 같음
    
    //기본형과 참조형 비교
    int age= 23;
    int itemp;
    itemp= age;
    age= 100;

    }

}
