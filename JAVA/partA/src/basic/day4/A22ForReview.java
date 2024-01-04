package basic.day4;

import java.util.Scanner;

//for문 복습: 1) ~5) 까지 구현 6) 구구단 출력하기(for in for)
public class A22ForReview {
    public static void main(String[] args) {
        int m;
        int n;
        int sum = 0;
        int result = 1;


        //1) 1부터 정수 n까지 더하기
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        for (int i = 0; i <= n; i++) sum += i;
        System.out.println(String.format("문제1) 1부터 %d 까지의 합계 : %d",n,sum));
        System.out.println("문제1) 1부터"+n+" 까지의 합계 : "+ sum );
        //2) 1부터 정수 n 까지 곱하기
        long longResult=1;                               //int 타입은 정수 -2147483648 ~ 2147483647 그래서 곱셈결과 크니까 long, double 등 이용
        for (int i = 0; i <= n; i++) longResult*=i;      //  n=20일 때, int result에 결과를 저장하면 -음수값이 나옵니다.(오버플로우)
        System.out.println(String.format("문제2) 1부터 %d 까지의 합계 : %d",n,longResult));
        System.out.println("문제2) 1부터"+n+" 까지의 합계 : "+ longResult );
        //3)시작값 정수 m 부터 마지막 값 n까지 더하기
        for (int i = 0; i <= n; i++) m+=m+i;

        // //4)시작값 정수 m 부터 마지막 값 n까지 곱하기
        m=4;
        longResult=1;
        for (int i = m; i <= n; i++) longResult*=i;
        
        // //5) 2의 n승 구하기 : 2를 n번 곱하기 (2진수에서 사용되는 연산)
        longResult=1;
        for (int i = 0; i <= n; i++) longResult*=2;
        System.out.println(String.format("문제5)2의 %d 승 구하기: %,d", n, longResult));


        //6) 구구단
        for(int i=1; i<10; i++)
        {   System.out.println(String.format("지금 %3d 단을 출력합니다",i));
            for(int j=1; j<10; j++) 
            System.out.println(String.format("%3d x %3d = %3d",i,j,i*j));
        }

    
    }


}
