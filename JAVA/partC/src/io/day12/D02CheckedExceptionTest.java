package io.day12;

import java.io.File;
import java.io.IOException;

//File Class : 운영체제 파일시스템을 다루는 시스템 클래스
public class D02CheckedExceptionTest {
    public static void main(String[] args) {
        //생성하려는 파일의 이름으로 File객체를 정의
        // File file = new File("F:\\test.md"); //지정된 경로를 찾을 수 없습니다
        File file = new File("test.md");         
        //디렉토리 지정하지 않으면 프로젝트와 같은 폴더에~~


    
        //File 생성 메소드
        try {
        //    if (file.exists())
                file.createNewFile();   //메소드는 처리해야할 예외가 있다
            System.out.println("file length : "+file.length());
        } catch (IOException e) { //IOException 처리 : 대표적인 Checked Exception
            //예외 객체는 변수 e로 참조
            System.out.println("파일 생성 오류 발생");
            System.out.println(e.getMessage()); //오류 원인
        } 
    }
}
