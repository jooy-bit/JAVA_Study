package project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtill;
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
    public void buy(BuyVo vo){
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
    public int update (Map<String,Integer> arg){//(BuyVo vo){
        int result = 0;
        String sql = "update tbl_buy set quantity = ?  where buy_idx = ?";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,arg.get("quantity"));//vo.getQuantity());
            pstmt.setInt(2,arg.get("buy_idx"));//vo.getBuy_idx());
            result = pstmt.executeUpdate();
        }catch (SQLException e) {
        System.out.println("update 실행 예외 : "+e.getMessage());
    }
    return result;
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

    //장바구니 모두 구메 batch(배치)는 일괄 처리 : 실행할 insert, update,delete 등의 데이터 저장 DML을 일괄처리한다
    //트랜잭션 : 특정요구사항에 대한 기능을 실행할 여러 SQL 명령들로 구성된 작업단위
    //          예시- cart에 저장된 상품 중 하나라도 참조 값이 없는 pcode가 있으면 rollback, 모두 정상이면 commit 트랜잭션 commit 모드가 auto에서 수동으로 변경
    //              => sql 트랜잭션 commit 모드가 auto -> 수동으로 변경 
    public int insertMany(List<BuyVo>cart){
        String sql = "insert into tbl_buy(buy_idx,cusomid,pcode,quantity,buy_date) values(BUY_PK_SEQ.nextval,?,?,?,sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            connection =getConnection();
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);        //※ auto 커밋 해제
            for (BuyVo vo : cart) {
                pstmt.setString(1, vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();   //sql을 메모리에 모아두기 insert sql에 대입되는 매개변수값은 매번 다릅니다
                count++;
            }
            pstmt.executeBatch();       //※ 모아둔 sql을 일괄 실행 , 실행 중 무결성 오류 생기면
            connection.commit();        //   catch에서 rollback
        } catch (SQLException e) {      //예외 발생 : 트랜잭션 처리
            try {
                connection.rollback();
                pstmt.close();
                connection.close();
            } catch (SQLException e1) {}
            count = -1;
            System.out.println("구매 부가능한 상품이 있습니다");
            System.out.println("장바구니 구메 실행 예외 발생 :  "+e.getMessage());
        }finally{       //정상실행와 예외 모두에 대해 자원 해제
            try{
                pstmt.close();
                connection.close();
            } catch(SQLException e2){}
        }return count;
    }

    public int money_of_dayByCustomer(String customid,String buydate){
        String sql = "{ call money_of_day(?,?,?) }";
        int money=0;
        try (
            Connection connection = OracleConnectionUtill.getConnection();
            CallableStatement cstmt = connection.prepareCall(sql)
            ) {
            //프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            //프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();      //프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);
            
        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }

        return money;
    }

}
