package io.day14;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//socket.png 그림참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다.
                    //  서버와 클라이먼트 연결 과정이 다르기 때문
//프로그램 실행은 서버가 먼저 실행
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedOutputStream bos =null;OutputStream os =null; DataOutputStream dos =null;
        InputStream is =null; DataInputStream dis =null;
        try {//서버소켓 생성
            server = new ServerSocket(); //서버 설정을 위한 소켓 
            server.bind(new InetSocketAddress("192.168.30.11",5050)); //서버 연결 정보 IP와 PORT 설정
            System.out.println("[서버프로그램] : 연결 요청을 기다리는 중입니다");
            socket = server.accept();    //입출력스트림을 위한 소켓
            //클라이언트 연결 요청(connect)에 대한 수락
            System.out.println("__연결을 수락합니다");         //accept 정상 완료
            os = socket.getOutputStream();
            //정수,실수,문자열 보내는 스트림
            dos = new DataOutputStream(os);    //보조 스트림
            dos.writeUTF(("\tForm 서버 >> 환영합니다"));
            //클라이언트가 보낸 인사말 받기
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            System.out.println(dis.readUTF());

            //이미지파일 받기
            String fileName = dis.readUTF();
            System.out.println("\t클라이언트 업로드 파일명 :  "+fileName);
            bos =new BufferedOutputStream(new FileOutputStream("c:\\Users\\Administrator\\Downloads"+fileName));
            int b; int count =0;
            while ((b=dis.read())!=-1) {
                bos.write(b);
                count++;
            }
            System.out.println("파일을 받았습니다. 총 바이트 :  "+count);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try { server.close(); socket.close();bos.close(); 
                dos.close(); is.close();;dis.close();os.close(); } catch (IOException e) {}
        }
    }
}
