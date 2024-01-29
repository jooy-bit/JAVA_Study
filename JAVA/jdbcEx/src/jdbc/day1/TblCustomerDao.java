package jdbc.day1;

import java.sql.*;
import java.util.*;

public class TblCustomerDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    //회원 가입
    public void join(CustomerVo vo){
        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date) "+"values(?,?,?,?,sysdate)";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 : "+e.getMessage());
        }
    }

    //회원 정보 수정 email, age 수정가능하게
    public void modify(CustomerVo vo){
        String sql ="UPDATE TBL_CUSTOM SET EMAIL = ?,age =? WHERE CUSTOM_ID = ?";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("modify 실행 예외 : "+e.getMessage());
        }
    }

    //회원 탈퇴
    public void delete(String customerId){
        String sql = "DELETE FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delect 실행 예외 : "+e.getMessage());
        }
        
    }

    //회원 정보 조회 select*from tbl_custom where custom_id = ?
    public CustomerVo getCustomer(String customerId){
        String sql ="select*from tbl_custom where custom_id = ?";
        CustomerVo vo = null;
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) vo= new CustomerVo(rs.getString("custom_id"),rs.getString("name"),rs.getString("email"),rs.getInt("age"),rs.getDate("reg_date"));
            rs.close();
        } catch (SQLException e) {
            System.out.println("getCustomer 실행 예외 : "+e.getMessage());
        }
        return vo;
    }

    //관리자 : 모든 회원정보 조회 select*from tbl_custom
    public List<CustomerVo> allCustomers(){
        ArrayList<CustomerVo> list = new ArrayList<CustomerVo>();
        String sql ="select*from tbl_custom";
        CustomerVo vo = null;
        try {Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            vo= new CustomerVo(rs.getString("custom_id"),rs.getString("name"),rs.getString("email"),rs.getInt("age"),rs.getDate("reg_date"));
            list.add(vo);
         } rs.close();
        } catch (SQLException e) {
            System.out.println("allCustomers 실행 예외 : "+e.getMessage());
        }
        return list;
    }
}
