package basic.day2;

public class A11StringMethod {

    public static void main(String[] args) {
        
        String message = "Hello, World:)";    
        //자바 메쏘드 괄호
             //메소드 인자의 개수와 형태
        //int java.lang.String.length()
             //1. none - length, isEmpty, toUppercase, toLowercase
        System.out.println("message.length() :" + message.length());
        System.out.println("message.toUpperCase() :" + message.toUpperCase());
        System.out.println("message.isEmpty() :" + message.isEmpty());

             //2. int one - charAt,*/ 
        System.out.println("message.charAt(8) :" + message.charAt(8));
        System.out.println("message.charAt(0) :" + message.charAt(0));
        System.out.println("message.charAt(4) :" + message.charAt(4));

            //index : 문자 문자열은 0부터 순서대로 문자에게 번호를 매긴다.
            //현재 message에서 마지막 인덱스는 length-1 (0부터 시작하니까)

             //3. string one - concat, equals, startsWith, EndsWith
        System.out.println("message.indexOf(\"World\") :" + message.indexOf("World")); //if it can't find the word, return -1
        System.out.println("message.concat(\"짱짱\") :" + message.concat(" 짱짱")); //return is boolean
        System.out.println("message.startsWith(\"Hello\") :" + message.startsWith("Hello"));
        System.out.println("message.endsWith(\")\") :" + message.endsWith(")"));


             //4. int two - subtring
        System.out.println("message.substring(1, 10) :"+ message.substring(1, 10));
        System.out.println("message.substring(2, 4) :"+ message.substring(2, 4));
        //endIndex는 포함되지 않는다


             //5. string(char) two - replace 
        System.out.println(message.replace("Hello", "Bye"));
        message = "hello";
        System.out.println("message.equals(\"hello\")" + message.equals("hello"));
        System.out.println("message.equals(\"Hello\")" + message.equals("Hello"));

            //return types
            //boolean   - equals, endsWith, startsWith, isEmpty
            //string    - toUpperCase, substring, concat, replace
            //int       - length, indexOf
            //char      - charAt, 



            // 질문 공유
            //1> 메소드의 리턴타입에 따라 결과를 저장할 변수를 일치하는 형식으로 선언
            //2> 문자리턴값으로 또 메소드 실행 가능
            // int len = message.length(); ==> 이걸 저장해서 데이터 처리가 중요!!
    }
        //자바 String의 중요한 메소드 10가지씩 조사해서 테스트 해보기
        //1. indexof()      //for finding the index of the first occurrence if a character or a string in the given string
            //indexOf(String str, int fromIndex) -> int

        //2.toCharArray()   //to form a new character array form this string
            //toCharArray() -> char[]
            
        //3.chatAt()        //to get character at the specified index
            //charAt(int index) -> char

        //4.concat()        //to append the passed string to the end of the given string
            //concat(String str) -> String

        //5.replace()       //to replace all the occurrences of the given character/String from given String
            //replace(char oldChat, char newChar) -> String

        //6.subtring()      //to get a part of a string from the given string
            //substring(int beginIndex, int endIndex) -> String

        //7.split()         //for splitting the given string based on the given regular Expression
            //split(String regex, int limit) -> String[]

        //8.comparaeTo()    //to compare two Srtings Lexicographically
            //compareTo(String anotherString) -> int

        //9.strip()         //to remove all trailing and leading whitespaces from the given string
            //strip() -> String

        //10.valueOf()      //to return String representation of the passed argument
            //valueOf(char[]data) -> String
            
    


    // *** 리턴값 형식을 기준으로 정리하기 ***S
    // 240102
    //입력 -> 처리 -> 출력의 과정을 항상 생각하자.
    //문장열 메소드에도 입력, 출력을 생각해 볼 수 있습니다. 입력은 메소드의 인자, 출력은 메소드의 리턴
    //          단,  message.charAt(숫자)를 예시로 하면 message는 메소드의 실행 주체(주인; 점을 찍음 system.out.println 시스템이 주인 ),print는 리턴이 없다(void), 
    //          그리고 리턴이 없는 메소드 있으며 그때는 void 이용




}
