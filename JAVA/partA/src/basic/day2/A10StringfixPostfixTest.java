package basic.day2;

public class A10StringfixPostfixTest {
      //public int indexof(int str, int formIndex) //str: Substring to be searched for, fromIndex : Search begins from this index


        
    
    
    public static void main(String[] args) {
        //String은 문자열 : 문자('')의 집합
        // String message = "Hello~ 안녕!! 하이하이";
        // System.out.println(message);
        // // char emo = '😍';  //char은 2바이트 이모지는 4바이트. 문자형으로 저장 안됨
        // String emo = "💕";
        // System.out.println(emo);
        // System.out.println("메시지 '" + message+ "'의 길이 : " + message.length());

        // message = "Welcome, Java World!";
        // System.out.println("메시지 '" + message+ "'의 길이 : " + message.length());


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
            
    }
}