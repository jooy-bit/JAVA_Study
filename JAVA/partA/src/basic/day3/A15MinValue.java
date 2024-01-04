package basic.day3;

public class A15MinValue {
    public static void main(String[] args) {
        //예시
        int n1 = 23, n2 = 34, n3 = 32;
        int Min;
        //1> 조건식이 참/ 거짓 각각 실행 명령어가 다릅니다
        if (n1<n2) {
            Min =n1;
        } else{
            Min =n2;
        }
        //2? 조건식이 참일때만 실해하는 명령어
        if (Min>n3) {
            Min = n3;
        }

        System.out.println("n1: "+n1+"  n2: "+n2+"  n3: "+n3);
        System.out.println("Min: "+Min);
        //조건 삼항연산을 대입문에 활용 가능
        n1 = 99; n2 = 88; n3 = 77;
        Min =(n1<n2? n1:n2);
        Min =(Min>n3? n3:Min);

        
        System.out.println("n1: "+n1+"  n2: "+n2+"  n3: "+n3);
        System.out.println("Min: "+Min);
        
        System.out.println("Min: " + (n1<n2? (n1<n3? n1:n3): (n2<n3? n2:n3)));
    }
}  
   
            // System.out.println("💕🎂고객님의 최종 포인트는 " +(point>150? (point+=200):(point+=100))+" 입니다.");

    
    
    


