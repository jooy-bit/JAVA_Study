package jdbc.day1;

public class Cart {
    public static void main(String[] args) {
        System.out.println("구매할 사용자 간편 로그인이 필요합니다");
        System.out.println("Id : __");

        System.out.println("[1]구매하기 [2]구매 취소 [3]구매 수량 변경 [4]종료");
        int select = Integer.parseInt(System.console().readLine());
        boolean run =true;

        while (run) {
            switch (select) {
                case 1://insert
                    
                    break;
            
                case 2://delete
                    
                    break;
                case 3://update
                    
                    break;
                case 4://off
                    
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
