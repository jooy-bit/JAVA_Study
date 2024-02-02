package JDBCteamProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCteamProject.vo.PlaceVo;

public class TblPlaceDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    public void deletePlace(PlaceVo pv){
        String sql = "DELETE\r\n"+"FROM TBL_PLACE_ADDRESS tpa\r\n"+"WHERE PLACE_SEQ = ?";
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) 
        {
                pstmt.setInt(1,pv.getPlace_seq());
                pstmt.executeUpdate();
	    } catch (SQLException e) {
            System.out.println("[place] 삭제 예외 발생: "+e.getMessage());
	    }
    }//deletePlace

    public void modifyPlace(int placeSeq, double newRate) {
        String sql = "UPDATE tbl_place SET rate = ? WHERE place_seq = ?";
    
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setDouble(1, newRate);
            pstmt.setInt(2, placeSeq);
            pstmt.executeUpdate();
            System.out.println("가게 평점이 수정되었습니다.");
        } catch (SQLException e) {
            System.out.println("가게 평점 변경 실행 예외 발생: " + e.getMessage());
        }
    }//modifyPlace

    public void randomRestorant(int place_seq){
    PlaceVo vo = null;
    
    String sql = "SELECT * FROM(SELECT *FROM TBL_PLACE tp WHERE RATE >= 4.5 ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <=3";

    try(
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
    ) {
        pstmt.setInt(1, place_seq);
        ResultSet rs = pstmt.executeQuery();
        vo =
    } catch (SQLException e) {
      System.out.println("randomRestorant 실행 예외 발생 : " + e.getMessage());
    }
    return vo;
    }//randomRestorant
}
