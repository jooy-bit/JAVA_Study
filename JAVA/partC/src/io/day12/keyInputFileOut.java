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
        }
    }
}
