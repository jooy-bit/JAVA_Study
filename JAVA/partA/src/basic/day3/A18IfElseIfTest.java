package basic.day3;

// if ~ else if ~ else if ~ ....
public class A18IfElseIfTest {

	public static void main(String[] args) {
		
		int menu;

		System.out.println(":::: 쇼핑몰 사용자 마이페이지 ::::");
		System.out.println("1:장바구니   2:찜 상품   3.배송 조회   4.구매 목록  5.종료");
		System.out.print("선택 하세요. >>>> ");
		
		menu=7;
		
		// 동일한 값인지 비교 : 관계연산자 == 또는 != 
		if(menu==1) {
			System.out.println("장바구니 🎁🎁🎁🎁 .많이 담아 주세요.");
		}else if(menu ==2) {
			System.out.println("찜 상품 입니다.❤❤");
		}else if(menu ==3) {
			System.out.println("배송 조회 🚚🚛🚚🚛 ");
		}else if(menu ==4) {
			System.out.println("구매 목록 입니다.");
		}else if(menu ==5) {
			System.out.println("종료 입니다.");
		}else {			// 메뉴값이 1,2,3,4,5 이외를 받아올때
			System.out.println("잘못된 선택 입니다.");
		}
		
		System.out.println("메뉴 선택 종료합니다.");
	
		int score = 178; // grade 계산 : 100-90:A  89-80:B 70-79:C 60-69:D -59:F
		String grade="";
		if (score > 100 || score < 0) {
			System.out.println("점수는 0~100 사이의 정수값입니다.");
			return;
		}

		if (score>=90) grade="A";
			else if (score>=80) grade="B";
			else if (score>=70) grade="C";
			else if (score>=60) grade="D";
			else if (score<60) grade="F";
		

		System.out.println("점수: "+score+ "점" + "학점: " + grade);




	}//Main
}//Class

