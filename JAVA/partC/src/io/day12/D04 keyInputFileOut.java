package io.day12;

import java.io.FileOutputStream;
import java.io.IOException;

public class keyInputFileOut {
    public static void main(String[] args) {
       int b;
        System.out.println("입력하세요. ↓");
        FileOutputStream fos = null;
        try {
            fos =new FileOutputStream("note.txt");      //인자로 파일명을 전달
            int count=0; 
            while ((b=System.in.read())!=-1) { 
                fos.write(b);       //파일출력스트림으로 데이터 보내기
                count++;
            }
            System.out.println("총 입력 바이트 수 :  "+count);
        } catch (IOException e) {
            System.out.println("예외: "+e.getMessage());
        }finally{
            //입출력 자원해제는 여기서 하세요. 예외 발생 상관없이 처리할 명령어
            try {fos.close();} catch (IOException e) {}
        }
    }
}
//File Input -> 화면(표준) 출력
//File Input -> File Output (파일복사)
//byte 기반 스트림은 문자형식의 파일이 아닐때
//문자기반 스트림 : 문자단위 입출력.
