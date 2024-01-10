package object.day8.day8_interface;

//인터페이스를 다중(여러개)으로 사용하는 구현 클래스 연습입니다.
//정리: 상속은 단일 상속, 인터페이스는 다중 구현
public class MyClassB implements InterfaceA , InterfaceX {
		
	//InterfaceA의 추상메소드 구현
	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int methodB(int num) {
		// TODO Auto-generated method stub

		return num/2*7;
	}
	
	//InterfaceX의 추상메소드 구현
	@Override
	public String methodX() {
		// TODO Auto-generated method stub
		return "나는 테스트";
	}
}
