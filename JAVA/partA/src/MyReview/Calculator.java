package MyReview;
class Cal{
    static int result = 0;
    static int add(int num){
        result += num;
        return result;
    }
}

public class Calculator {
    public static void main(String[] args) {
        System.out.println(Cal.add(3));
        System.out.println(Cal.add(4));
        
    }

}
