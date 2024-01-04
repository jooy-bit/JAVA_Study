package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        //예시
        int n1 = 23, n2 = 34, n3 = 32;
        int max;
        //1> 조건식이 참/ 거짓 각각 실행 명령어가 다릅니다
        if (n1>n2) {
            max =n2;
        } else{
            max =n2;
        }
        //2? 조건식이 참일때만 실해하는 명령어
        if (max<n3) {
            max = n3;
        }

        System.out.println("n1: "+n1+"  n2: "+n2+"  n3: "+n3);
        System.out.println("MAX: "+max);
        //조건 삼항연산을 대입문에 활용 가능
        
        max =(n1>n2? n1:n2);
        max =(max<n3? n3:max);

        
        System.out.println("n1: "+n1+"  n2: "+n2+"  n3: "+n3);
        
        System.out.println("Max: " + (n1>n2? (n1<n3? n3:n1): (n2<n3? n3:n2)));
    }
}  
   
            // System.out.println("💕🎂고객님의 최종 포인트는 " +(point>150? (point+=200):(point+=100))+" 입니다.");

    
    
    


