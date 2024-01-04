package basic.day2;

public class A09HangulCharTest {

    public static void main(String[] args) {
        char start = '나';
        int codeNa = start;
        int codeNet = '냿';

        // // 나부터 냿까지  while문으로 출력해보세요.
        while (codeNa<= codeNet) {
            System.out.print((char)codeNa++);
        }
        System.out.print("\n"+start); //start는 변경되지 않았음. codeNa 값만 변경

        codeNa = start; //그래서 그냥 사용 가능

        // //모두 몇개의 문자가 있는지 개수를 구하시오.
        System.out.println("\n'나'에서 '냿'까지 문자의 개수는 "+(codeNet-codeNa+1)+"개 입니다.");

        start = '나';
        char end = '낟';
        codeNa = start;
        codeNet = end ;
        //1>
        while (start <= end) {
            System.out.print(start++);            
        }
        //이 시점에서 start의 값은?
        System.out.print("\nstart=???"+start);
        //2>
        start = '나';
        System.out.print("\n\n\n"+start+"~"+end+"까지의 개수는 " + (codeNet-codeNa+1));


        


        
    }
}