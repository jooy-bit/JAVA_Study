package jdbc.day2;

import java.util.List;

import project.dao.ProductDao;
import project.dao.TblbuyDao;
import project.vo.BuyVo;
import project.vo.ProductVo;

public class CartApp_2 {
//static이 많아지면 상속의 특징을 사용할 수 없습니다. 멀티 스레드 환경에 적합하지 않습니다
    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회    [P] 상품명 검색     [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }
    // public static void showMypage(){

    //     List<CustomerByVo> list = dao.selectCustomerList(customId);
    //                 for (CustomerByVo vo : list) {
    //                     System.out.println(vo);
    //                 }
    //                 System.out.println("-".repeat(60));
    // }

    public static void main(String[] args) {
        CartApp_2 app = new CartApp_2();
        TblbuyDao dao = new TblbuyDao();
        ProductDao pao = new ProductDao();

        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customId = System.console().readLine();
        System.out.println("♥♥♥♥♥ "+customId +" 님의 방문을 환영합니다 ♥♥♥♥♥");

        //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
        //또는 상품명으로 검색 (구매할 상품 조회)
        //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
        
        System.out.println("\n[C] 카테고리별 상품 조회    [P] 상품명 검색     [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        boolean run = true;

        while (run) {       //메뉴 선택 반복
            showMenu();
            BuyVo vo = new BuyVo(null, customId, null, 0, null);
            System.out.print("선택>>>>");
            String select = System.console().readLine();
            switch (select) {
                case "M","m": //나의 구매내역
                    
                    break;
                                //[2] 구매 취소 - delete
                                //  [3] 구매 수량 변경 - update
                case "c","C":
                    System.out.println("카테고리 : A1-과일  A2-수입과일  B1-인스턴스  B3-선물세트  C1-과자");
                    System.out.print("카테고리입력>>>>");
                    String category = System.console().readLine();
                    List<ProductVo> Cproduct =pao.selectByCategory(category);
                    for (ProductVo productVo : Cproduct) {
                        System.out.println(productVo);
                    }
                    break;

                case"p","P":
                    System.out.print("상품명 입력>>>>");
                    String pname =System.console().readLine();
                    List<ProductVo> pName = pao.selectByPname(pname);
                    for (ProductVo productVo : pName) {
                        System.out.println(productVo);
                    }
                    break;

                case"B","b":
                    System.out.println("[B]구매하기");
                    System.out.print(" 제품 코드를 입력하세요. __ ");
                    String pcode = System.console().readLine();
                    System.out.print(" 제품 수량를 입력하세요. __ ");
                    int quantity = Integer.parseInt(System.console().readLine());
                    vo = new BuyVo(0, customId, pcode, quantity, null);
                    dao.buy(vo);
                    break;

                case"D","d":
                    System.out.println("[D]구매취소");
                    System.out.print(" 제품 번호를 입력하세요. __ ");
                    int buy_idx = Integer.parseInt(System.console().readLine());
                    vo = new BuyVo(buy_idx, null, null, 0, null);
                    dao.delete(vo);
                    break;

                case"Q","q":
                    System.out.println("[Q]구매취소");
                    System.out.print(" 제품 번호를 입력하세요. __ ");
                    buy_idx = Integer.parseInt(System.console().readLine());
                    System.out.print(" 제품 수량를 입력하세요. __ ");
                    quantity = Integer.parseInt(System.console().readLine());
                    vo = new BuyVo(buy_idx, null, null, quantity, null);
                    dao.update(vo);
                    break;

                case "X","x": 
                        run= false;
                        break;
                default:
                    break;
            }
        }

    }
}   // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java 
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java  
    //         테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.     
    //         insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.       
