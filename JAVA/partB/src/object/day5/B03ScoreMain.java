package object.day5;

import java.util.Scanner;

//학생 4명의 성적을 저장해보세요.
//1학년 2명(모모,다현) 3과목 2학년 2명(나연, 쯔위) 5과목
public class B03ScoreMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Score scoreCal = new Score();
        int[] tempArray= new int[5];
        System.out.print("이름을 입력해 주세요. >>>>");
        
        String ln = sc.nextLine();//이름 받을 스트링
        scoreCal.setName(ln);//이름받아옴
        System.out.print("학년을 숫자로 입력해 주세요.예)1학년 - 1 >>>>");
        int j= sc.nextInt();//키보드로 학년 받기
        scoreCal.setGrade(j);//학년 받아옴
        
        //키보드로 점수 받기
        if (j<2) {//1학년
                tempArray= new int[3];
                for (int i = 0; i < tempArray.length; i++){     
                    System.out.print("과목 점수를 입력해 주세요.>>>>");
                    tempArray[i]=sc.nextInt();}
            }else{//2학년
                tempArray= new int[5];
                for (int i = 0; i < tempArray.length; i++) {
                    System.out.print("과목 점수를 입력해 주세요.>>>>");
                    tempArray[i]=sc.nextInt();
            }
        }
        scoreCal.setJumsues(tempArray);
        scoreCal.sum();
        scoreCal.printScore();
    }

}
