package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {
    public static void main(String[] args) {
        Connection conn = null;     //1) object.jar 라이브러리 프로젝트에 추가
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//localhost:1521/XE"; //localhost는 서버 ip로 대체 될 수 있다
        String user = "C##IDEV";
        String passward = "1234";
        try{ //2) object.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            //java 6부터 jdbc4.0버전이 지원되고 그 때부터 생략가능
            //DriverManager가 드리이버 클래스를 알아서 로드
            Class.forName(driver); //런타임 시점에 클래스 로드
                                    //ClassnotFoundException 체크드 익셉션 처리 필요
            //3) Connection 구현 객체를 생성 - DriverManager는 드라이버 관리하는 유틸리티 클래스
            conn = DriverManager.getConnection(url, user, passward);//T4CConnection DriverManager가 알아서 해줌
                                                //SQLException 예외 처리 필요
            //Connection은 인터페이스에 대한 구현은 드라이버에 따라 정해진다
            System.out.println("데이터베이스 연결 객체 : "+ conn); //데이터베이스 연결 객체 : oracle.jdbc.driver.T4CConnection@6b53e23f
            if (conn != null) {
                System.out.println("Connection 객체의 구현 클래스 : " //데이터베이스 연결 객체 : oracle.jdbc.driver.T4CConnection@6b53e23f
                + conn.getClass().getName());
                System.out.println("오라클 데이터베이스 연결 성공");
            }
        }catch(Exception e){
                System.out.println("오라클 데이터베이스 연결 실패");
                System.out.println("예외 발생 : "+e.getMessage());
        }finally{
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}