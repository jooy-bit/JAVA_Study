package object.day7;
/*
 * 자바 기본 패키지 = java.jang
 * 지금 테스트할 Math 클래스는 java.jang에 속하여 import 필요없으나
 * Scanner 클래스와 같이 java.utill 등 다른 패키지에 속한 클래스는 import를 해야합니다
 *              - import를 통해서 이 프로그램에서 사용할 클래스를 메모리 올립니다.
 * 
 */
public class B08MathTest {
    public static void main(String[] args) {
    System.out.println("1.최대값 max, 최소값 min 구하기");
    System.out.println("Math.max(56,12) ="+ Math.max(56,12));               //인자와 리턴타입 정수
    System.out.println("Math.max(56.34,99.123)="+ Math.max(56.34,99.123));  //인자와 리턴타입 실수
    int min = Math.min(45, 56);
      //double dmin = Math.min(45, 56);         //자동 캐스팅
    double dmin = Math.min(56.78, 111.44);
      //int imin = (int)Math.min(56.78, 111.44);//강제 캐스팅
      
    System.out.println("min = "+min);
    System.out.println("dmin = "+dmin);

    System.out.println("위의 메소드 이용해서 3개의 정수 34, 56, 12의 최댓값과 최솟값 구하기");
    System.out.println("최솟값: "+Math.min(12,Math.min(34,56))+"\n최댓값: "+Math.max(34, Math.max(56, 12)));

        //Math 클래스 가본 수학 공식을 해결하는 메소드 
        //복습 : static 메소드는 클래스 객체를 생성하지 않고 바로 클래스 이름으로 실행되는 메소드이다.


    }
}
