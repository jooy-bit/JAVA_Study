package basic.day4;

public class A24StaticMethod {
    
    //메소드가 실행될 떄 실매개 변수 값이 형식매개변수로 전달, 저장됩니다.
    //메소드 목적
    //특정 처리 기능을 main에서 따로 분리하기 
    // 한번 만들어진 메소드는 여러번 필요할 때 실행할 수 있습니다.
    // 메소드는 클래스의 구성요소
    /**
     * @param args
     */
    public static void main(String[] args){
    // argumentTest();
    // argumentTest(8,4);
    // int result = resultIntTest();
    // System.out.println("resultIntTest() : "+result);
    // boolean resultBoolean = resultBooleanTest();
    // System.out.println(resultBoolean);
    double k =add(3.56, 32, 4);
    System.out.println(k);


}
        //리턴이 없는 메소드 = 인자로 선언된 ()안 변수는 메소드의 지역변수
        //인자가 없는 메소드
        public static void argumentTest(){
            System.out.println("인자값 없는 메소드");
        }
        //인자가 하나인 메소드
        public static void argumentTest(int i){                 //이 범위 안에서만 사용가능한 변수
            System.out.println("인자가 1개 정수 "+i+" 입니다.");
        }
        //인자가 두개인 메소드
        public static void argumentTest(int i, int j){

        }
        
        

        //리턴값이 int인 메소드
        public static int resultIntTest(){
            return 999;
        }
        //리턴값이 boolean인 메소드
        public static boolean resultBooleanTest(){
            return false;
        }
        //리턴값이 String인 메소드
        public static String resultStringTest(){
            return "Hello";
        }
        //리턴값이 char인 메소드
        public static char resultCharTest(){
            return 'A';
        }

        public static double add(double a, long b, int c){
            return a+b+c; //double type can input double long int etc
        }

}//
