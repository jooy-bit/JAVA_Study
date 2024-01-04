package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {
        //A25클래스에서 만든 메소드를 사용할 수 있습니다.
        //***메소드가 private로 정의시 다른 클래스에서 사용 불가*** 
        int result=A25MySampleMethod.sumMToN(10, 13);
        System.out.println(result);
        /*자바 (또는 다른 프로그래밍언어)로 코딩할 떄
         * 1. 자바에서 제공하는 클래스와 메소드를 잘 활용하기
         * 2.필요에 따라 여러분은 개발자가 직접 잘 만들어서 사용하기
         * 
         * 
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("시작값 입력>>>");
        int start = sc.nextInt();
        System.out.print("마지막값 입력>>>");
        int end = sc.nextInt();
        System.out.println(start + " ~ " + end + "까지 곱한 결과: " + A25MySampleMethod.MultiplyMToN(start, end));

    }

}
