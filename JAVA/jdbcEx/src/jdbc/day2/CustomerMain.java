package jdbc.day2;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

public class CustomerMain {
    public static void main(String[] args) {
        System.out.println("[고객 관리 시스템] 고객을 조회합니다");
        System.out.print("고객 아이디 입력 : __");
        String customerId = System.console().readLine();
        System.out.println("\n"+"~~~~~~~~~~조회 결과~~~~~~~~");
        TblCustomerDao dao = new TblCustomerDao();
        CustomerVo vo = dao.getCustomer(customerId);
        System.out.println(vo);
        
    }//main
}//class