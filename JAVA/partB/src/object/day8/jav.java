package object.day8;

public class jav {
    /* 모든 자바 클래스의 부모는 object 타입 */
    public static void main(String[] args) {
        //Object 타입으로 업캐스팅
        Object ob1 = new String();
        // Object ob2 = new Diamond();
        Object ob3 = 3; //3은 int정수 -> Interger 객체로 변경 -> Object로 참조
        //기본형 타임 Wrapper 클래스로 객체로 변경되서 Object로 업캐스팅
                    //-- Byte, Character, Short, Integer, Long, Float, Double
                    //-- 다른 자료구조 List, Map, Set 등은 객체(클래스) 타입만 다룹니다.
        //Object 클래스의 메소드 - 모든 자바클래스가 상속 받고 있습니다.
        // getClass, toString, hashcode, equals, 그 외는 스레드 관련 메소드
        //String 클래스 equals 는 object 메소드 재정의 (오버라이드)
        System.out.println("ob1.getClass() = "+ob1.getClass().getName());
        // System.out.println("ob2.getClass() = "+ob2.getClass().getName());
        System.out.println("ob3.getClass() = "+ob3.getClass().getName());

        //해쉬코드는 객체의 식별값을 반환한다
        //toString 확인 참조변수를 출력할 때 문자열 표현값 반환
                                            //Intrgr, String 이 toString으로 재정의
        System.out.println(ob1.toString()); //toString 메소드는 생략하고 쓸 수 있다. Object toString의 기본값 출력
        System.out.println(ob1.hashCode()+" "+Integer.toHexString(ob1.hashCode()));//toHexSting은 16진수로 바꿔줌
        //toString이 다 다르게 나오는 이유. String이 오버라이딩한 거임 ㅋㅋ


    //Object 클래스의 toString메소드를 오버라이드
        // @Override
        // public String toString(){
        //     return "Diamond []"; }


    }//
}//
