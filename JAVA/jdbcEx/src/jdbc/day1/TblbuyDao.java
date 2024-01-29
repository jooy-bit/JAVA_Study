package jdbc.day1;

import java.sql.*;
import java.util.*;

public class TblbuyDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //[1]구매하기 
    public void buy(BuyVo vo){
        String sql = "insert into tbl_buy(buy_idx,cusomid,pcode,quantity,buy_date)"+"value(BUY_PK_SEQ,?,?,?,sysdate)";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1,vo.getCustomid());
                pstmt.setString(2,vo.getPcode());
                pstmt.setInt(3,vo.getQuantity());
                pstmt.executeUpdate();
            }catch (SQLException e) {
            System.out.println("buy 실행 예외 : "+e.getMessage());
        }
    }
    
    
    //[2]구매 취소 
    public void delete(){
        String sql = "delete from tbl_buy where "
    }
    
    
    //[3]구매 수량 변경
}
