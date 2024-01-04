package basic.day3;

public class A17ForNWhileExam {
    public static void main(String[] args) {
        for ( char start = 'A'; start <= 'Z'; start++ ) System.out.print(start);
        System.out.print("\n");
        
        String message ="Hello, World~ Hoi";

        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            System.out.println("i="+i+",문자="+temp);
            System.out.println();
        }//for end

        int K = 0;
        while(K<=message.length()) {
            char temp = message.charAt(K);
            System.out.println("K: "+K+",char: "+temp);
            K++;
        }
        
        
        // while 구문 활용
        char start = 'A';
        while ( start<='Z' ) System.out.print(start++);


        System.out.println("\n2.문자열 길이 만큼 반복문 실행하면서 if 조건문으로 문자열 검사하기");
        System.out.println("\t문자열에서 알파벳 \'o\'의 갯수 구해봅시다.");


        int count =0;
        message = "hello? Wolrd~ hoi";

        for (int i = 0; i < message.length(); i++) 
        {
            char temp =message.charAt(i);               
            if (temp == 'o') count++;
        }
        System.out.println("\'o\'의 갯수는 "+count);

        int i = 0;
        count = 0;
        while (i<message.length()) 
        { 
            char temp = message.charAt(i);
            if (temp=='o') count++;
            i++;
        }
        System.out.println("\'o\'의 갯수는 "+count);
    }//main end

}//class end
