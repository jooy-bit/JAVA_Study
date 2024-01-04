package basic.day2;

public class A06PrefixPostfixTest {

    public static void main(String[] args) {
        
        int start = 100;
        /*start++ ++start start = start +21 */

        System.out.println("== postfix 확인 (출력 후에 +1) ==");
        System.out.println(start);
        System.out.println(start++); //출력 후 ++
        System.out.println(start++);
        System.out.println(start++);
        System.out.println(start++);
        System.out.println(start++);
        System.out.println(start++);
        System.out.println(start++);
        System.out.println(start++);
        System.out.println(start++);

        start = 100;
        System.out.println("== postfix 확인 (출력 전에 +1) ==");
        System.out.println(start);
        System.out.println(++start); //출력 전 ++
        System.out.println(++start);
        System.out.println(++start);
        System.out.println(++start);
        System.out.println(++start);
        System.out.println(++start);
        System.out.println(++start);
        System.out.println(++start);
        System.out.println(++start);

    }
}