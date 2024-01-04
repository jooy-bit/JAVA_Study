package basic.day4;
//변수 선언 위치 -> 변수 사용 범위가 결정됩니다. 
public class A21VariableArea {
    int number =999;                            // 1. 클래스 범위에서 사용되는 변수 
    static int ABC =100;                        // static은  static변수만 사용가능! static이 아닌 변수는 사용 못함! >0</
    public static void main(String[] args) {
        
        int a = 23;                             // 2. main 메소드 범위에서 사용되는 변수
        for (int i = 0; i < 10; i++) {          // 3. for문(특정 블럭) 범위에서 사용되는 변수 - i
            System.out.println("i=" +i);
        }

        while (a==23) {                         //3-1. while문(특정 블럭) 범위에서 사용되는 변수 - count
            int count;
            System.out.println("a="+a);
            count=100;
            System.out.println("count="+count); //종료 조건이 없으면 무한 반복 (loop) 이러면 안됩니다 ㅜㅠ
            a=24;
        }

        System.out.println("a="+a);
        // System.out.println("number="+number); //이건 오류가 난다. static을 가진 int 선언은 메소드 안에서 사용이 가능하다.
        // System.out.println("i="+i);           //문법적인 오류 - i와 count는 for, while 안에서만 태어나고 죽는 lifecycle을 가진다!!
        // System.out.println("count="+count);
    }//

}//
