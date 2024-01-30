package jdbc.day2;

import java.sql.*;
import java.util.*;

import jdbc.day1.OracleConnectionUtill;
import project.vo.CustomerVo;

public class Select {

    public static void main(String[] args) {
        List<CustomerVo> list = Selectall_3();
        for (CustomerVo customerVo : list) {
            System.out.println(customerVo);
        }
        

    }//main

        public static List<CustomerVo> Selectall_3(){
            //3 레코드 행을 자바 객체와 1:1로 매핑
        Connection connection = OracleConnectionUtill.getConnection();
        ArrayList<CustomerVo> list = new ArrayList<CustomerVo>();
        CustomerVo vo = null;
        String sql = "select*from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                vo = new CustomerVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
                list.add(vo);
            }
        } catch (SQLException e) {
           System.out.println("예외 발생 : " + e.getMessage());
        }
            return list;
        }
        public static void SelectAll_2() {//rs.next 
            Connection connection = OracleConnectionUtill.getConnection();
            String sql = "select*from tbl_custom";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString("custom_id"));
                System.out.println(rs.getString("email"));
                }
            } catch (SQLException e) {
               System.out.println("예외 발생 : " + e.getMessage());
        }
    }

        
        public static void SelectAll_1() { //rs.next 테스트
            Connection connection = OracleConnectionUtill.getConnection();
            String sql = "select*from tbl_custom";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                System.out.println(rs.getString(1));
                System.out.println(rs.getTimestamp(5));
            
            } catch (SQLException e) {
               System.out.println("예외 발생 : " + e.getMessage());
            }
        
    }

}//class
