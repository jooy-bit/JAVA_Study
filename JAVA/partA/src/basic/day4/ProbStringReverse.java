package basic.day4;

public class ProbStringReverse {


    public static void main(String[] args) {

        String message = "안녕하세요 좋은 하루네요!";
        char[] messageArray = new char[message.length()];
       
        for (int i = message.length()-1; i >= 0; i--)
        /*{ //char temp = message.charAt(i);*/ 
            System.out.print(message.charAt(i)/*temp */);
        //}
        
        
        
        
        int ci = message.length()-1;
        for (int i = 0; i < message.length(); i++) {
        char temp =message.charAt(i);           //i=0일떄
        messageArray[ci]=temp;                  //ci=10
        ci--;
       }
        System.out.println(messageArray);

        //2)리버스 이용
        System.out.println("StringBuffer");
        StringBuffer sb = new StringBuffer(message);//StringBuffer 생성
        System.out.println(sb.reverse()); // sgnaY
        // String reversedMessage = sb.reverse().toString();
        // System.out.println(reversedMessage);
        /*String과 StringBuffer(Builder)의 차이점은 
            String은 고정된 길이의 불변(immutable)문자열, 짧은 문자열
        StringBuffer와 StringBuilder의 차이점은
        - StringBuffer는 각 메서드별로 Synchronized Keyword가 존재하여, 멀티스레드 환경에서도 동기화를 지원.
        - 반면, StringBuilder는 동기화를 보장하지 않음.

        단순히 성능만 놓고 본다면 연산이 많은 경우, StringBuilder > StringBuffer >>> String 입니다.
                                            출처: https://12bme.tistory.com/42 [길은 가면, 뒤에 있다.:티스토리]

            1. 문자열 변경이 빈번하지 않는다면 String 사용을 고려
            2. 문자열이 빈번하게 변경되면서 멀티쓰레드 환경이라면 StringBuffer 사용을 고려
            3. 문자열이 빈번하게 변경되면서 멀티쓰레드 환경이 아니라면 StringBuilder 사용을 고려
        */
//=================================================================================================//
            StringBuffer sd = new StringBuffer("message"); // 최초 "message"로 생성
            System.out.println(sd.toString()); // message
            System.out.println("뒤집어 보자 : " + sd.reverse()); // 뒤집어 보자 : egassem
            System.out.println(sd.toString()); // egassem
            sd.delete(1,3); // "ga" 삭제
            System.out.println(sd.toString()); // essem
            sd.deleteCharAt(3); // essm
            System.out.println(sd.toString()); // essm
            sd.replace(1,5, "ZZYX"); // "ssm"를 "ZZYX"로 치환
            System.out.println(sd.toString()); // eZZYX
    }
}

