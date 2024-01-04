package basic.day2;
<<<<<<< HEAD
import java.time.LocalDateTime;

public class HomeStringFomat {
    public static void main(String[] args) {
        String str = "StringFormatExample";
        boolean bool = true;
        int n = 1234;
        LocalDateTime now = LocalDateTime.now();
        
        String result = String.format("문자열 서식: %s, %S", str, str);
        System.out.println(result);
        
        result = String.format("boolean 서식 문자열: %B, %b", bool, bool);
        System.out.println(result);
        
        result = String.format("정수 서식: %d, %o, %x, %05d", n, n, n, n); 
        System.out.println(result);  // %05d → 5자리수, 공백을 0으로 채움
        
        result = String.format("부동 소수점 서식: %4$e, %3$f, %2$g, %1$a", 1234.01, 1234.02, 1234.03, 1234.04);
        System.out.println(result);  // %숫자$ 로 절대 인수 인덱스 지정
        
        result = String.format("날짜/시간 서식: %tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초", now);
        System.out.println(result);  // $< 로 상대 인덱스 지정하여 직전의 인수와 같은 인덱스를 이용
      
    }
}
=======

public class HomeStringFomat {
    
   public static void main(String[] args) {
    
    int t = 100;
    System.out.println(String.format("10진수(%d) : 2진수(%s), 8진수(%o), 16진수(%x)", t, Integer.toBinaryString(t), t, t));

    
    
    int i = 23;

    System.out.println(String.format("%d_", i));
    System.out.println(String.format("%5d_", i));
    System.out.println(String.format("%-5d_", i));
    System.out.println(String.format("%05d_", i));



    i = 123456789;

    System.out.println(String.format("%,d_", i));
    System.out.println(String.format("%,15d_", i));
    System.out.println(String.format("%,-15d_", i));
    System.out.println(String.format("%,015d_", i));
    



    
    i = 123456789;

    System.out.println(String.format("%,d_", i));
    System.out.println(String.format("%,15d_", i));
    System.out.println(String.format("%,-15d_", i));
    System.out.println(String.format("%,015d_", i));




    double n = 123.45678;

    System.out.println(3.4);
    System.out.println(n);
    System.out.println();

    System.out.println(String.format("%f_", 3.4));
    System.out.println(String.format("%f_", n));
    System.out.println(String.format("%.6f_", n));
    System.out.println(String.format("%15f_", n));
    System.out.println(String.format("%-15f_", n));
    System.out.println(String.format("%.3f_", n));
    System.out.println(String.format("%.2f_", n));
    System.out.println(String.format("%15.2f_", n));
    System.out.println(String.format("%-15.2f_", n));
    System.out.println(String.format("%015f_", n));
    System.out.println(String.format("%015.2f_", n));


   System.out.println("Unicode 코드 → 문자");
   System.out.println(String.format("48 → %c, 57 → %c", 48, 57));
   System.out.println(String.format("65 → %c, 90 → %c", 65, 90));
   System.out.println(String.format("97 → %c, 122 → %c", 97, 122));
   System.out.println(String.format("44032 → %c, 55203 → %c", 44032, 55203)); //  U+AC00, U+D7A3
   }


   
   


}
>>>>>>> 2bd3681d68d6c0965d9513a13655ed45c2e10fc3
