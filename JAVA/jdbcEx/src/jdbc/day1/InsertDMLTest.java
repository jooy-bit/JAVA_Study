package jdbc.day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.vo.CustomerVo;

public class InsertDMLTest {    //insert data 값이 고정된 예시
    public static void main(String[] args) {
        System.out.println("우리 쇼핑몰 [회원가입] 환영합니다");
        System.out.print("아이디를 입력하세요.__");
        String customId = System.console().readLine();
        System.out.print("이름를 입력하세요.__");
        String name = System.console().readLine();
        System.out.print("이메일를 입력하세요.__");
        String email = System.console().readLine();
        System.out.print("나이를 입력하세요.__");
        int age = Integer.parseInt(System.console().readLine());
        CustomerVo vo = new CustomerVo(customId, name, email, age, null);
        insert(vo);
        //결론 : tbl_custom 테이블은 회원정보를 저장합니다
        //      개발 프로그램은 '회원가입','로그인','회원정보수정','회원탈퇴' 기능을 tbl_custom 테이블에 대해 갖게 된다
        // => 필요한 기능에 처리해야할 SQL 실행 메소드를 DAO(Data Acess Object)클래스에 모두 만듭니다
    }//main

    public static void insert(CustomerVo vo){    //메소드 실행 인자는 insert매개변수에 전달될 값
        Connection conn = OracleConnectionUtill.getConnection();
        if(conn!=null) System.out.println("데이터베이스 연결 성공!!");
        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date) "+"values(?,?,?,?,sysdate)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 : "+e.getMessage());
        } finally {
            OracleConnectionUtill.close(conn);
        }
    } 

    //insert SQL에 리터럴 값이 아닌 매개변수를 전달 받습니다
    public static void param_data(){
        Connection conn = OracleConnectionUtill.getConnection();
        if(conn!=null) System.out.println("데이터베이스 연결 성공!!");

        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date) "
                    +"values(?,?,?,?,sysdate)";
        //PreparedStatement는 매개변수를 ?로 표기하고 SQL을 미리 컴파일합니다.
        //매개변수 ? 에 대입되는 (바인딩) 값을 SQL excute메소드 이전에 실행한다
        //응용프로그램에서 매개변수에 저장될 값은 사용자 입력값입니다
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            //매개변수 바인딩 ?는 순서대로 인덱스를 갖습니다 시작값 1
            pstmt.setString(1, "sana");
            pstmt.setString(2, "최사나");
            pstmt.setString(3, "sana@naver.com");
            pstmt.setInt(4, 26);
            //auto close를 위한 try 형식 - pstmt.close()필요하므로 try-with-resources 사용
            //pstmt.execute(); //Sql 실행 메소드
            pstmt.executeUpdate(); //리턴값 int는 반영된 행의 개수를 리턴
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 : "+e.getMessage());
        } finally {
            OracleConnectionUtill.close(conn);
        }
    }

    public static void fixed_data(){
        Connection conn = OracleConnectionUtill.getConnection();
        if(conn!=null) System.out.println("데이터베이스 연결 성공!!");

        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date) "
                    +"values('nayeong','박나영','nay@gmail.com',24,sysdate)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 : "+e.getMessage());
        } finally {
            OracleConnectionUtill.close(conn);
        }
    }//fix
}//class

//주제 : 키오스크, 단어장, 주소록, 테이블 1~3개 
//(팀별 주제 통일 == 테이블 구조와 데이터 동일하게)
//간단한 JDBC 연습 프로그램
//샘플 데이터는 조원들끼리 나눠서 입력하기
//코딩은 각자(DML 연습)하면서 서로 질의응답
//main 프로그램이 메뉴 선택 등 인터페이스 만드는 과정이 복잡해 질 수 있고, JDBC는 기본 형식에 따라 합니다
//진도 1.5 조별프로그램1.5