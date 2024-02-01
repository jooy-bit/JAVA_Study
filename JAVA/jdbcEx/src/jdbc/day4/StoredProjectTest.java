package jdbc.day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.day1.OracleConnectionUtill;

public class StoredProjectTest {
    public static void main(String[] args) {
        exec_money_of_day();
    }

    private static void exec_max_customer(){
        Connection connection = OracleConnectionUtill.getConnection();
        String sql ="{ call max_custom(?,?) }";//프로시저 sql 형식 "{call 프로시저 이름}"
        try (CallableStatement cstmt = connection.prepareCall(sql)) {
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.registerOutParameter(2, Types.NUMERIC);
            cstmt.executeUpdate();
            System.out.println("구매 수량이 가장 많은 고객 정보를 조회한 결과입니다.");

            //index 1 OUT 실행 값 가져오기
            System.out.println("고객 이름 :  "+cstmt.getString(1));
            System.out.println("고객 나이 :  "+cstmt.getInt(2));
        } catch (SQLException e) {
            System.out.println("max_customer 예외 발생 :  "+ e.getMessage());
        }

    }

    private static void exec_money_of_day(){
        Connection connection = OracleConnectionUtill.getConnection();
        String sql ="{ call money_of_day(?,?,?) }";//프로시저 sql 형식 "{call 프로시저 이름}"
        System.out.println("고객ID와 날짜를 입력하면 총 구매금액을 조회합니다");
        System.out.print("고객 ID입력_");
        String customid = System.console().readLine();
        System.out.print("구매 날짜입력_");
        String buy_date = System.console().readLine();
        try (CallableStatement cstmt = connection.prepareCall(sql)) {
            cstmt.setString(1, customid);
            cstmt.setString(2, buy_date);
            cstmt.executeUpdate();
            cstmt.registerOutParameter(3, Types.NUMERIC);
            String result = String.format("%s 고객님이 %s에 구매한 총 구매금액 :  %,8d", customid,buy_date,cstmt.getInt(3));
            //index 1 OUT 실행 값 가져오기
        } catch (SQLException e) {
            System.out.println("money_of_day 예외 발생 :  "+ e.getMessage());
        }

    }
}
