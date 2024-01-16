package io.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D08FileReader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
       //readByChar();
       readByChar();
       readByCharArray();
       long end = System.currentTimeMillis();
       System.out.println(String.format("실행 소요 시간: %,d ms", (end-start)));
    }

    
    public static void readByChar(){
        String filePath = "C:\\Windows\\PFRO.log";     
        StringBuilder content = new StringBuilder();            //문자열 저장하고 변경할 수 있는 가변 객체
        int charValue;
        int count=0;
        int b;

       try( FileReader fr = new FileReader(filePath)){

         while ((charValue = fr.read()) != -1) {            //read는 문자단위 입력. 문자를 1개씩 읽음(입력)
            //System.out.print((char)charValue);           //문자단위라 표준출력가능
            // int 값을 char로 변환하여 StringBuilder에 추가
            content.append((char)charValue);
            count++;
        }   
    } catch (Exception e) { }
        // FileReader 닫기

        // 파일에서 읽은 내용 출력
        System.out.println(content.toString());
        System.out.println("읽은 문자수 : "+count);
    }

    public static void readByCharArray(){
        String filePath = "C:\\Windows\\PFRO.log";
        //StringBuilder content = new StringBuilder();
        char[] charValues = new char[256];
        int count=0; int charCount=0;
        int b;

       try( FileReader fr = new FileReader(filePath)){
        
         while ((b = fr.read(charValues,0,256)) != -1) {    //read(배열이름, 시작인덱스, 최대문자길이)
            //읽은 문자의 개수는 리턴 b에 저장
            System.out.println(new String(charValues,0,b)); //String 생성자 : 배열이름,시작위치, 길이 를 인자로 문자열 만듦
            // int 값을 char로 변환하여 StringBuilder에 추가
            //content.append(charValues,0,b);
            charCount+=b;       //문자의 개수 세는 수식
            count++;           //while 반복 횟수 수식
        }   
    } catch (Exception e) { }
        // FileReader 닫기

        // 파일에서 읽은 내용 출력
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        //System.out.println(content.toString());
        System.out.println("읽은 문자수 : "+charCount);
        System.out.println("반복 횟수 : "+count);
    }

    public static void readByCharBuffer(){
        String filePath = "C:\\Windows\\PFRO.log";
        //StringBuilder content = new StringBuilder();
        int count=0; //라인 단위로 입출력 가능
        int b;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line=br.readLine())!=null) 
            {
                System.out.println(line);
                count++;
            }
        }catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }
        System.out.println("읽은 라인 수 :  "+count);
    }

}
