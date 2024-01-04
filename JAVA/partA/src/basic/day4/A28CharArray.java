package basic.day4;

public class A28CharArray {
    public static void main(String[] args) {
        String message = "Hello~ World~ 자바는 맛있다.";    
        char[] messageArray = new char[message.length()]; //문자열의 길이 == 어레이의 길이
        for (int i = 0; i < messageArray.length/*message.length()*/; i++) {
            char temp =message.charAt(i);
            System.out.print(temp);
            messageArray[i] = temp;
        }
        System.out.println("\n" + messageArray);           //char 배열의 특징

        //고대암호: '모모'가 '나연'에게 비밀쪽지를 보낸다. 암호문을 만든다.
        //          두사람이 알고 있는 비밀키 값 KEY=7을 정한다. 암호문은?
        int key = 7;
        for (int i = 0; i < message.length(); i++) {
            messageArray[i]+=key;
            
        }
        System.out.print("비밀쪽지 : ");//Olssv?'^vysk?'잗받늛'맢잏닫5
        System.out.println(messageArray);//모든 글자에 7을 더한 값, 아스키코드를 이용..
        System.out.println("나연이는 받은 쪽지를 읽으려고 암호문을 풀었다.");
        for (int i = 0; i < message.length(); i++) {
            messageArray[i]-=key;
            
        }
        System.out.println(messageArray);

    }


}
