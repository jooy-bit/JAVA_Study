package io.day13;

import java.io.IOException;
import java.util.Scanner;

import collection.myapp.JavaWord;
import io.javaword.JavaWordList;

public class ReviewProb {
    public static void main(String[] args) throws IOException {
        prod_8();
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

    public static void prod_10()throws IOException{
        byte[] input = new byte[20];
        System.in.read(input);
        System.out.println(new String(input));
    }
    
}
