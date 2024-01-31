package jdbc.day3;

import java.util.ArrayList;
import java.util.List;

import project.dao.TblbuyDao;
import project.dao.ProductDao;
import project.vo.BuyVo;
import project.vo.CustomerByVo;
import project.vo.ProductVo;

// CartApp_4 는 다른 클래스의 상위 클래스로 상속 관계를 만들 수 있다.
//              ㄴ 단,  main 메소드도 제거하고 
//                      인스턴스 메소드는 pivate 이외 다른  접근 한정자로 해야합니다.     
public class CartApp_4 {
    //이 클래스의 전역변수 선언 - 모든 메소드에서 사용 가능
    private TblbuyDao buyDao = new TblbuyDao();
    private ProductDao productDao = new ProductDao();
    private List<BuyVo> cart = new ArrayList<>();       //장바구니

    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[C] 카테고리별 상품 조회      [P] 상품명 검색     [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소  [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println("::장바구니::[A] 담기  [L] 목록  [R] 삭제   [Y] 모두 구매 ");
        System.out.println(".".repeat(70));
    }

    private void showMyPage(String customerid) {
        List<CustomerByVo> result = buyDao.selectCustomerList(customerid);
                    for(CustomerByVo vo : result)  
                            System.out.println(vo);
    }

    private void showProductListByCategory() {
        System.out.println("카테고리 : A1-과일 A2-수입과일  B1-인스턴스  B2-선물세트 C1-과자류");
        System.out.print("카테고리 입력__");
        String category = System.console().readLine();
            List<ProductVo> Cproduct =productDao.selectByCategory(category);
            for (ProductVo productVo : Cproduct) {
                System.out.println(productVo);
            }
      
    }

    public void searchProductListByPname() {
        System.out.print("상품명 검색어 입력__");
        String pname =System.console().readLine();
        List<ProductVo> pName = productDao.selectByPname(pname);
        for (ProductVo productVo : pName) {
            System.out.println(productVo);
        }
    }                    

    private void addCartItem(String customerid) {
        System.out.println(".................. 장바구니 :: 물품 담기 ...................");
        System.out.print("구매할 상품코드 입력하세요.__");
        System.out.print("구매할 수량 입력하세요.__");
     }

    private void showCartList() {
        System.out.println(".................. 장바구니 :: 목록 보기...................");
    }

    private void removeCartItem() {
        System.out.println(".................. 장바구니 :: 물품 삭제 ...................");
        System.out.print( "삭제할 번호 입력__");
        System.out.println("물품을 장바구니에서 삭제했습니다.");
    }

    private void buyCartItems() {
        System.out.println(".................. 장바구니 :: 물품 모두 구매 ...................");
    }

       //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
       //또는 상품명으로 검색 (구매할 상품 조회)
       //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
    public static void main(String[] args) {
        CartApp_4 app = new CartApp_4();
        app.start();
    }
    
    public void start() {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        System.out.println(customerid + " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select) {
                case "M","m":   // 나의 구매내역
                    showMyPage(customerid);
                    break;
                case "C","c":
                    showProductListByCategory();
                    break;  
                case "P","p":
                    searchProductListByPname();    
                    break;
                case "A","a":
                    addCartItem(customerid);
                    break;
                case "L","l":
                    showCartList();
                    break;
                case "R","r":
                    removeCartItem();
                    break;    
                case "Y","y": //여러번의 insert를 실행시키는 메소드CustomerByVo
                    buyCartItems();
                    break;
                case "X","x":
                    run=false;
                    break;                
                default:
                    break;
            }
        }

    }






}   