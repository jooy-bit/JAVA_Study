package basic.day3;

public class A16MinMaxValue {
    public static void main(String[] args) {
        //예시
        int n1 = 23, n2 = 34, n3 = 32;
        int min;
        int max;
        //1> 조건식이 참/ 거짓 각각 실행 명령어가 다릅니다
        if (n1<n2) {
            min= n1;
            max= n2;
        } else{
            min= n2;
            max= n1;
        }
        //2? 조건식이 참일때만 실해하는 명령어 //참 거짓을 시행시 명령이 1개이면 () 생략
        if (min > n3) min = n3;
        if (max < n3) max= n3;

        System.out.println("n1: "+n1+"  n2: "+n2+"  n3: "+n3);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        
        //조건 삼항연산을 대입문에 활용 가능
        n1 = 99; n2 = 88; n3 = 77;
        min =(n1<n2? n1:n2);
        min =(min>n3? n3:min);

        
        System.out.println("n1: "+n1+"  n2: "+n2+"  n3: "+n3);
        System.out.println("min: "+min);
        
        System.out.println("min: " + (n1<n2? (n1<n3? n1:n3): (n2<n3? n2:n3)));
    }
}  
   
            // System.out.println("💕🎂고객님의 최종 포인트는 " +(point>150? (point+=200):(point+=100))+" 입니다.");

    
    
    


