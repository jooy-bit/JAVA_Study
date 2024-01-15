package io.day12;

import java.util.Scanner;

public class TryCatchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요. > ");
        int number =Integer.parseInt(sc.nextLine());
        System.out.println("입력한 값 :  "+number);
    }
    
    public static void indexException(){
        int[] arrays = {11,22,33,44,55};
        System.out.println(arrays[0]);   
        System.out.println(arrays[1]);   
        System.out.println(arrays[arrays.length]);
    }
}
