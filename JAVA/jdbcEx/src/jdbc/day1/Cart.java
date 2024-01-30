package jdbc.day1;

public class Cart {
    public static void main(String[] args) {
        System.out.println("구매할 사용자 간편 로그인이 필요합니다");
        System.out.print("Id : __");
        String customId = System.console().readLine();
        System.out.println("[1]구매하기 [2]구매 취소 [3]구매 수량 변경 [4]종료");

        int select = Integer.parseInt(System.console().readLine());
        boolean run =true;
        TblbuyDao dao = new TblbuyDao();
        while (run) {
            switch (select) {
                case 1://insert
                System.out.print(" 제품 코드를 입력하세요. __ ");
                String pcode = System.console().readLine();
                System.out.print(" 제품 수량를 입력하세요. __ ");
                int quantity = Integer.parseInt(System.console().readLine());

                BuyVo vo = new BuyVo(0, customId, pcode, quantity, null);
                dao.buy(vo);
                break;
            
                case 2://delete
                    System.out.print(" 제품 번호를 입력하세요. __ ");
                    int buy_idx = Integer.parseInt(System.console().readLine());
                    vo = new BuyVo(buy_idx, null, null, 0, null);
                    dao.delete(vo);
                    break;
                case 3://update
                    System.out.print(" 제품 수량를 입력하세요. __ ");
                    quantity = Integer.parseInt(System.console().readLine());
                    System.out.print(" 제품 번호를 입력하세요. __ ");
                    buy_idx = Integer.parseInt(System.console().readLine());
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
