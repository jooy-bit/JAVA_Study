package object.day6;

import java.util.Random;
import java.util.Scanner;

public class AddQuizMain {

    public static void main(String[] args) {
        
        Random random =new Random();
        Scanner sc =new Scanner(System.in);
        AddQuiz MathTest = new AddQuiz();
        int Numbers =10;
        int[] frontNumber = new int[Numbers];
        int[] backNumber = new int[Numbers];
        int[] answer = MathTest.getUserAnswer();
        int correctCount = 0;
        int a =1;

        System.out.println("덧셈"+Numbers+"문제 퀴즈를 시작합니다.");
        for (int i = 0; i < Numbers; i++) {
            int num1 = random.nextInt(88)+11;
            int num2 = random.nextInt(88)+11; 
            System.out.println( a+i +"번."+num1+"+"+num2+"= ?");
            System.out.print("답 입력하세요. >>> ");
            int an =sc.nextInt();

            frontNumber[i]=num1;
            backNumber[i]=num2;
            answer[i]=an;

        }

        a=1;
        boolean IsRight;
        System.out.println("::::: 채점 하고 있습니다. :::::");
        System.out.println("\t문제\t제출한답\t정답\t채점");
        for (int j = 0; j < Numbers; j++) {a++;
            frontNumber[j] = MathTest.getData1();
            backNumber[j] = MathTest.getData2();
            if (answer[j]==frontNumber[j]+backNumber[j]){ 
                IsRight= true;
                correctCount++; 
            }else IsRight=false;
            System.out.println(String.format("%d번.\t%d+%d\t%d\t\t%d\t%b", 
            a+j ,frontNumber[j],backNumber[j],answer[j],frontNumber[j]+backNumber[j],IsRight));          
            }
        System.out.println("\n:::맞은개수는 "+correctCount+" 입니다.:::");


            
    }


}


