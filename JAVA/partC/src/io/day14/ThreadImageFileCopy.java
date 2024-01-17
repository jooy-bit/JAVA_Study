package io.day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadImageFileCopy {

    public static void main(String[] args) {
        //실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다.
        // ㄴ 1초마다 "." 출력하기 => 새로운 쓰레드를 만듭니다.
        //1)Thread 클래스 상송 2)Runnable 인터페이스 구현하기
        //1.쓰레드가 할일을 인터페이스로 활용하여 정의 =>익명 클래스
        final Runnable runnable = new Runnable() {
            @Override   //쓰레드가 할 일을 여기에 코딩
            public void run() {
                boolean run = true;
                while (run) {
                    System.out.println(".");
                    try { Thread.sleep(500); 
                    } catch (InterruptedException e) {
                        
                        run =false;  //InterruptedException 끼어들다
                }
            }
        }
        };
        //2.쓰레드 생성하기 할일은 생성자 인자로 전달
        Thread thread = new Thread(runnable);
        //3.쓰레드 실행
        thread.start();
        copyByByte();
        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));
        //4.쓰레드 종료를 위해 인터럽트 발생
        thread.interrupt();
        
    }//main
    public static void copyByByte() {
        int b; int count=0;
        FileInputStream fis = null;
        FileOutputStream fos= null;
        try{
            fis= new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
            fos = new FileOutputStream("계곡복사.jpg");
            while((b=fis.read()) != -1){
                fos.write(b);
                count++;
            }
        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }finally {
            try{ fis.close(); fos.close();} catch(IOException e) {}
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }//copy
    
}//class

