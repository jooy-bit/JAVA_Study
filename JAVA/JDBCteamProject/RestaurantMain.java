package JDBCteamProject;

import JDBCteamProject.dao.TblAreaUnitDao;
import JDBCteamProject.dao.TblMenuDao;
import JDBCteamProject.dao.TblPlaceAdressDao;
import JDBCteamProject.dao.TblPlaceDao;
import JDBCteamProject.vo.AreaUnitVo;
import JDBCteamProject.vo.MenuVo;
import JDBCteamProject.vo.PlaceAddressVo;
import JDBCteamProject.vo.PlaceVo;

public class RestaurantMain {

    private TblPlaceDao placeDao = new TblPlaceDao();
    private TblPlaceAdressDao placeAdressDao = new TblPlaceAdressDao();
    private TblAreaUnitDao AreaUnitDao = new TblAreaUnitDao();
    private TblMenuDao menuDao = new TblMenuDao();
    private PlaceVo placeVo = new PlaceVo(0, null, null, 0, null, null, null);
    private MenuVo MenuVo = new MenuVo(0, 0, null, 0);
    private PlaceAddressVo placeAddressVo = new PlaceAddressVo(0, null, 0);
    private AreaUnitVo areaUnitVo = new AreaUnitVo(0, null);

    public void findName() {

    }// findName

    public void findArea() {

    }// findArea

    public void showRate() {

    }// showRate

    public void randomFind() {

    }// randomFind

    public static void addRasturant() {

    }// addRasturant

    public static void modifyResturant() {

    }// modifyResturant

    public void joinAdressBook() {
        System.out.println(".".repeat(50));
        System.out.println("[A] 이름으로 맛집 찾기     [B]지역 별로 맛집 찾기   [C]평점 순위 보기   [D] 랜덤 맛집 뽑기 ");
        System.out.println("[E] 맛집 추가                [F]맛집 수정               [G]삭제                [H]종료");
        System.out.println(".".repeat(50));
    }// joinAdressBook

    public void removeAdressBook() {
        System.out.println(".".repeat(50));
        System.out.println("추방할 맛집 ID를 알려주세요");
        System.out.println(".".repeat(50));
        System.out.print("ID >>>");
        String place_seq = System.console().readLine();
        if (place_seq != null) {
            placeVo = new PlaceVo();
            deletePlaceAddress(placeVo);
            System.out.println("맛집이 추방되었습니다. 새로운 맛집을 탐방해주세요");
        }
    }// removeAdressBook
}
