package io.day14;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

//socket.png 그림참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다.
                    //  서버와 클라이먼트 연결 과정이 다르기 때문
public class Client {
    public static void main(String[] args) {
        Socket socket =null;
        try {
            System.out.println("[클라이언트] 프로그램 입니다");
            socket = new Socket();
            Thread.sleep(3000);  //시간 중지 타입 설정
            socket.connect(new InetSocketAddress("192.168.30.11",5050)); //서버 설정한 bind 정보와 같은 객체를 만듭니다.
            System.out.println("__연결성공 하였습니다");
            //서버가 클라이언트에게 데이터 보내기 : 출력 스트림
            //클라이언트와 서버가 연결된 소켓으로 출력 스트림 생성
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF());

            //서버에 인사말 보내기
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            System.out.print("서버에게 보낼 메시지를 쓰세요__");
            dos.writeUTF("\tForm 클라이언트 >>"+ System.console().readLine());
            //이미지 파일을 서버에 보내기(업로드)
            String filePath = "tom.gif";
            FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int b;
            while ((b=bis.read())!=-1) {
                dos.write(b);
            }
            System.out.println("파일 업로드 완료");
        } catch (IOException |InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {socket.close();} catch (Exception e){}
        }
    }
}
