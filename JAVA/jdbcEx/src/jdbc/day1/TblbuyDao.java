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
        String sql = "insert into tbl_buy(buy_idx,cusomid,pcode,quantity,buy_date) values(BUY_PK_SEQ.nextval,?,?,?,sysdate)";
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
    public void delete(BuyVo vo){
        String sql = "delete from tbl_buy where buy_idx =?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setInt(1,vo.getBuy_idx());
                pstmt.executeUpdate();
            }catch (SQLException e) {
            System.out.println("delete 실행 예외 : "+e.getMessage());
        }
    }
    
    
    //[3]구매 수량 변경
    public void update(BuyVo vo){
        String sql = "update tbl_buy set quantity = ?  where buy_idx = ?";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,vo.getQuantity());
            pstmt.setInt(2,vo.getBuy_idx());
            pstmt.executeUpdate();
        }catch (SQLException e) {
        System.out.println("update 실행 예외 : "+e.getMessage());
    }
    }

    //리스트 id 별로 수량보기
    public BuyVo getBuy(String pname){
        String sql ="select*from tbl_Buy where cusomid = ?";
        BuyVo vo = null;
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, pname);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) vo= new BuyVo(rs.getInt("buyIdx"),rs.getString("customId"),rs.getString("pcode"),rs.getInt("quantity"),rs.getDate("buyDate"));

            rs.close();
        } catch (SQLException e) {
            System.out.println("getBuy 실행 예외 : "+e.getMessage());
        }
        return vo;
    }

}
