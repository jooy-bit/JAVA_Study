package jdbc.day2;

import java.util.List;

import project.dao.ProductDao;
import project.dao.TblbuyDao;
import project.vo.BuyVo;
import project.vo.ProductVo;

public class CartApp {
    public static void main(String[] args) {
        TblbuyDao dao = new TblbuyDao();
        ProductDao po = new ProductDao();
        ProductVo pv = new ProductVo(null, null, null, 0);
        System.out.println("구매할 사용자 간편 로그인이 필요합니다");
        System.out.print("Id : __");
        String customId = System.console().readLine();
        BuyVo vo = new BuyVo(null, customId, null, 0, null);
        List<BuyVo> list = dao.getBuy(customId);
        for (BuyVo buyVo : list) {
            System.out.println(buyVo);
        }
        
        System.out.println("[1]구매하기 [2]구매 취소 [3]구매 수량 변경 [4]종료");
        //상품 목록을 선택한 카테고리에 대해 보여주기
        //또는 상품명으로 검색
        //또는 입력한 아이디로 구매한 구매내역 보여주기


        int select = Integer.parseInt(System.console().readLine());
        boolean run =true;
        while (run) {
            switch (select) {
                case 1://insert
                System.out.println("[1]구매하기");
                System.out.print(" 제품 코드를 입력하세요. __ ");
                String pcode = System.console().readLine();
                System.out.print(" 제품 수량를 입력하세요. __ ");
                int quantity = Integer.parseInt(System.console().readLine());

                vo = new BuyVo(0, customId, pcode, quantity, null);
                dao.buy(vo);
                break;
            
                case 2://delete
                    System.out.println("[2]구매취소");
                    System.out.print(" 제품 번호를 입력하세요. __ ");
                    int buy_idx = Integer.parseInt(System.console().readLine());
                    vo = new BuyVo(buy_idx, null, null, 0, null);
                    dao.delete(vo);
                    break;
                case 3://update
                System.out.println("[3]구매취소");
                System.out.print(" 제품 번호를 입력하세요. __ ");
                buy_idx = Integer.parseInt(System.console().readLine());
                System.out.print(" 제품 수량를 입력하세요. __ ");
                quantity = Integer.parseInt(System.console().readLine());
                    vo = new BuyVo(buy_idx, null, null, quantity, null);
                    dao.update(vo);
                    break;
                    default:
                    break;
            }
        }
    }
    
}//class
//tbl_buy 테이블을 대상을 insert, update, delete,할수 있는 dao 클래스 TblbuyDao.java
//          테이블 컬럼과 1:1 대응되는 BuyVo.java
//          테이블 PK컬럼은 buy_idx -> update, delete의 조건 컬럼 입니다.
