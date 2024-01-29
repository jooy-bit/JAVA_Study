package jdbc.day1;

import java.sql.*;
import java.util.*;

public class ProductDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<ProductVo> allProducts(){
        ArrayList<ProductVo> list = new ArrayList<ProductVo>();
        String sql = "select*from tbl_product";
        ProductVo vo = null;
        try {Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            vo= new ProductVo(rs.getString("pcode"),rs.getString("category"),rs.getString("pname"),rs.getInt("price"));
            list.add(vo);
         } rs.close();
        } catch (SQLException e) {
            System.out.println("allProducts 실행 예외 : "+e.getMessage());
        }
        return list;
    }

    public ProductVo getProduct(String pname){
        String sql ="select*from tbl_product where pname = ?";
        ProductVo vo = null;
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, pname);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) vo= new ProductVo(rs.getString("pcode"),rs.getString("category"),rs.getString("pname"),rs.getInt("price"));

            rs.close();
        } catch (SQLException e) {
            System.out.println("getCustomer 실행 예외 : "+e.getMessage());
        }
        return vo;
    }

}
