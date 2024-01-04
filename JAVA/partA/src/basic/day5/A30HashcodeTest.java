package basic.day5;

public class A30HashcodeTest {
    public static void main(String[] args) {
        
    int[] iArray= new int[10];
    String message = "Hello World:)";
    
    //hashcode는 참조값(식별값)을 만드는 해쉬함수로 생성된 결과입니다.

    System.out.println(iArray); //배열의 식별값을 보여줍니다.(16진수 8자리)
    System.out.println("초기 hashCoe: "+ iArray.hashCode()); //해쉬코드값을 가져옵니다(10진수)
    System.out.println("배열 요소값을 변경한 후 해시코드: "+Integer.toHexString(iArray.hashCode()));//10진수를 16진수로 변환합니다
    //결론: 배열값이 변경되어도 메모리의 위치는 동일합니다

    System.out.println("\n String 배열 message의 해시코드 값: "+ message.hashCode());
    message= message+ "~Good";
    System.out.println("message를 변경한 후 해시코드 값: "+ message.hashCode());
    //결론: 문자열 String 은 배열이 변경되면 메모리 위치가 변경됩니다


    }
}
/*      객체: 여러 종류의 데이터가 모여있는 데이터 덩어리.(기본형은 데이터의 최소단위)
 *          객체는 참조형 변수를 사용합니다. (변수가 주소를 저장합니다.)
 *          객체 메모리에 저장했어요     -->초기에 저장한 데이터를 바꿀 수 있다(배열) 가변객체
 *                                     -->초기에 저장한 데이터를 바꿀 수 없다(String ...) 불변객체
 * 
 * 
 */