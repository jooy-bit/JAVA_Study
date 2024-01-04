package basic.day3;
import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    int menu;
    int money;//입금액 또는 출금액
    int balance=0;//잔액
    boolean run = true;

        //세자리 마다 , 찍기: 
    DecimalFormat df = new DecimalFormat("금 #,### 원");

    

    while(run){

        System.out.println("----------------------------------------");
        System.out.println("1. 예금  | 2. 출금  | 3. 잔액  | 4. 종료");
        System.out.println("----------------------------------------");   
        System.out.print("메뉴 선택 >>> ");
        menu = sc.nextInt();
        switch (menu) {
            case 1: // 입금
                System.out.print("예금액 >");
                money = sc.nextInt();
                balance += money;
                System.out.println("고객님의 잔액은 " + df.format(balance) + " 입니다");
                break;
            case 2: // 출금
                System.out.print("출금액> ");
                money = sc.nextInt();
                if (money<balance) System.out.println("잔액보다 큰 금액은 출금 불가합니다.");
                else{
                    balance -= money;
                    System.out.println("고객님의 잔액은 " + df.format(balance) + " 입니다");
                }
                break;
            case 3: // 잔금
                System.out.println("현재잔고: "+ df.format(balance) );
                break;
            case 4: // 종료
                System.out.println("프로그램을 종료합니다.");                
                run= false;
        
            default: // 이외 번호입력 시 출력
                System.out.println("선택값은 1~4입니다.");
                break;
        }//switch d
    }//while d
    }//main d
}//class d
