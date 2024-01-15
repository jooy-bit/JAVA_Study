package io.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//파일 입력스트림으로 이미지 파일 읽어온다
// ==> 파일 출력 스트림으로 파일 내용을 출력한다
public class D06FileCopyTest {
    public static void main(String[] args) {
        FileInputStream fis= null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("C:\\Users\\Administrator\\Pictures\\maxresdefault.jpg");
            fos = new FileOutputStream("maxresdefault.png");
            int count=0;
            int b;
            while ((b=fis.read())!=-1) {
                fos.write(b);
                count++;
            }
            System.out.println("count:  "+count);
        }catch(IOException e){
            System.out.println("파일 입출력 예외 :  "+e.getMessage());
        }finally{
            try{fis.close();} catch (IOException e) {}

        }
    }
}

