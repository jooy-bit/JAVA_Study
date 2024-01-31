package project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.vo.BuyVo;
import project.vo.CustomerByVo;

public class TblbuyDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
//excuteUpate 메소드는 insert,update,delete가 정상 실행(반영된 행 있으면)되면 1을 리턴
//                      특히 update, delete는 조건에 맞는 행이 없어서 반영된 행이 없으면 "0" 리턴
//[1]구매하기 
    public int buy(BuyVo vo){
        String sql = "insert into tbl_buy(buy_idx,cusomid,pcode,quantity,buy_date) values(BUY_PK_SEQ.nextval,?,?,?,sysdate)";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
                pstmt.setString(1,vo.getCustomid());
                pstmt.setString(2,vo.getPcode());
                pstmt.setInt(3,vo.getQuantity());
                pstmt.executeUpdate();
            }catch (SQLException e) {
                //customid 와 pcode는 참조테이블에 존재하는 값으로 해야 무결성 위반 오류 발생 안함
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
    
    
    //[3]구매 수량 변경 pk는 행 식별합니다. 특정 행을 수정하려면  where 조건컬럼은 buy_idx(pk)
    public void update (Map<String,Integer> arg){//(BuyVo vo){
        String sql = "update tbl_buy set quantity = ?  where buy_idx = ?";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,arg.get("quantity"));//vo.getQuantity());
            pstmt.setInt(2,arg.get("buy_idx"));//vo.getBuy_idx());
            pstmt.executeUpdate();
        }catch (SQLException e) {
        System.out.println("update 실행 예외 : "+e.getMessage());
    }
    }

    //리스트 id 별로 수량보기
    public List<CustomerByVo> selectCustomerList(String customId){
        List<CustomerByVo> list = new ArrayList<CustomerByVo>();
        String sql ="SELECT BUY_IDX, TB.PCODE, PNAME, PRICE, QUANTITY,BUY_DATE \r\n" +
        "FROM TBL_BUY TB \r\n" +
        "LEFT JOIN TBL_PRODUCT TP \r\n" +
        "ON TB.PCODE = TP.PCODE \r\n" +
        "WHERE TB.CUSTOMID = ? \r\n"+
        "ORDER BY PNAME ASC";
        ;
                        CustomerByVo vo = null;
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, customId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vo= new CustomerByVo(rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getInt(5),rs.getTimestamp(6));
                list.add(vo);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("selectCustomerList 실행 예외 : "+e.getMessage());
        }
        return list;
    }

}
