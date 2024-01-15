package io.day12;

import java.io.FileInputStream;
import java.io.IOException;

//File Input -> Screen Output
public class D05FileInputSysOut {
    public static void main(String[] args) {
        FileInputStream fis=null;
        try {            //바이트기반 스트림 read 메소드는 데이터 1바이트씩 읽어옴
            fis = new FileInputStream("test.md");
            int b;
            int count=0;
            while ((b=fis.read())!=-1) {        //파일에 끝을 만나면 -1 입니다
                System.out.write(b); 
                count++;           //윈도우 터미널 인코딩 방식은 MS949(ANSI형식)       
            }
            System.out.println("count :  "+count);
        } catch (IOException e) {//FileNotFoundException의 부모 예외로 처리
            System.out.println("파일 입력 중 예외 발생 : "+e.getMessage());
        }  finally{try{fis.close();}catch(IOException e){};}
    }
}

