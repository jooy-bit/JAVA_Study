package project.dao;

import java.sql.*;
import java.util.*;

import project.vo.ProductVo;

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

    //
    public ArrayList<ProductVo> selectByPname(String pname){
        ArrayList<ProductVo> list = new ArrayList<ProductVo>();
        String sql ="SELECT *FROM TBL_PRODUCT WHERE PNAME LIKE '%'||?||'%'";
        ProductVo vo = null;
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, pname);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vo= new ProductVo(rs.getString("pcode"),
                                rs.getString("category"),
                                rs.getString("pname"),
                                rs.getInt("price"));
                list.add(vo);
            
                            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("getCustomer 실행 예외 : "+e.getMessage());
        }
        return list;
    }

    public ArrayList<ProductVo> selectByCategory(String category){
        ArrayList<ProductVo> list = new ArrayList<ProductVo>();
        String sql ="SELECT * FROM TBL_PRODUCT WHERE CATEGORY = ?";
        ProductVo vo = null;
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vo= new ProductVo(rs.getString("pcode"),
                                rs.getString("category"),
                                rs.getString("pname"),
                                rs.getInt("price"));
                list.add(vo);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("getCustomer 실행 예외 : "+e.getMessage());
        }
        return list;
    }


    public Map<String,Integer> getPriceTable(){
        Map<String, Integer> map = new HashMap<>();

        ResultSet result;
        String sql = "SELECT SUM(PRICE*QUANTITY)  \r\n" + //
                "FROM TBL_BUY TP\r\n" + //
                "JOIN TBL_PRODUCT TB \r\n" + //
                "ON TB.PCODE = TP.PCODE\r\n" + //
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
                
                result = pstmt.executeQuery();
                System.out.println(result.getString(1));
            } catch (SQLException e) {
                System.out.println("getPriceTable 실행 예외 : "+e.getMessage());
        }
    }


}
