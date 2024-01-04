package basic.day2;

public class A08PreView {

    public static void main(String[] args) {
        
        char start= 'A';

    //반복명령 While문
        while (start<='Z') {

            System.out.print(start++);

        }

        while (start>'A') {

            System.out.print(--start);

        }
    }
}