package io.day13;

import java.io.IOException;
import java.util.Scanner;

import collection.myapp.JavaWord;
import io.javaword.JavaWordList;

public class ReviewProb {
    public static void main(String[] args) throws IOException {
        prod_10();
    }
    public static void prod_8(){
        JavaWordList words =new JavaWordList("단어장.txt");
        words.fileLoad();
        words.add(new JavaWord("null", "비어있는", 1));
        //words.remove(-9);   //words.remove(10);     2)
        //개발자가 만드는 예외 
        //1) 예외가 발생되는 문법오류, 실행 오류 없지만 값의 범위를 제한하기 위해 예외 발생
        //2) 기존 발생하는 예외를 새로운 내용으로 변경할 때
    }

    /* public static void prod_10() throws IOException {
        byte[] input = new byte[20];
        System.in.read(input);
        System.out.println(new String(input));
    } */
    public static void prod_10(){
        byte[] buffer =new byte[20];
        try {
            int b = System.in.read(buffer);
            System.out.println("입력한 바이트 수:  "+b);
            //System.out.println("입력한 문자열:  "+new String(buffer));
            System.out.println("입력한 문자열 정수 변환:  "+ Integer.parseInt(new String(buffer).trim()));
        } catch (IOException | NumberFormatException e) {
            //2개의 예외를 처리합니다 참고 : || 논리적인 OR, | 비트단위 OR
            System.out.println("IOException 또는 NumberFormatException 예외를 처리합니다");
            e.printStackTrace();
            /* 
             *  Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
                at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
                at java.base/java.lang.Integer.parseInt(Integer.java:668)
                at java.base/java.lang.Integer.parseInt(Integer.java:786)
                at io.day13.ReviewProb.prod_10(ReviewProb.java:34)
                at io.day13.ReviewProb.main(ReviewProb.java:11)
             */
        }
    }
    
}
