package io.day12;

import java.io.IOException;

//표준 입출력 키보드 테스트
//키보드 입력 : new Scanner(System.in), 또는 System.console().readLine()
//표준입출력은 모든 글자가 2바이트 => window treminal incoding ANSI
//표준입력(콘솔장치 - 키보드) :  키보드 입력 => 입력버퍼 (저장장치,완충) =>프로그램 메모리
// 
public class D03StandardIOTest {
    public static void main(String[] args) {
        int b;
        System.out.println("입력하세요. ↓");
        try {
            int count=0; 
            while ((b=System.in.read())!=-1) { //-1(입력끝)은 ctrl+z
                b=System.in.read();         //원초적 입력
                // System.out.println(b);   //문자 인코딩 안하고 정수값 출력
                //System.in.read()로 입력받은 정수값을 문자로 인코딩하는 메소드
                System.out.write(b);
                count++;
            }
            System.out.println("총 입력 바이트 수 :  "+count);
        } catch (IOException e) {
            System.out.println("예외: "+e.getMessage());
        }
    }
    
}
