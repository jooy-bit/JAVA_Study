package object.day8.day8_interface;
    //CharSequence는 자사에서 만든 인터페이스
public class B18CharSequenceTest {
    public static void main(String[] args){

        CharSequence csstr =new String("Hello Java");
        CharSequence cssb = new StringBuilder("Hi Java");

        String temp = "자바 Hello~Hi Java";
        System.out.println("charsequence 타입을 인자로 하는 메소드인지 확인");
        System.out.println("contain temp 객체에 csstr 문자열이 포함되어 있는가?");
        System.out.println(temp.contains(csstr)); //false
        System.out.println(temp.contains(cssb)); //false
        System.out.println(temp.contains("Hello~")); //true

        
    }
}
