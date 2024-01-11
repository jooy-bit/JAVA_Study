package collection.myapp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JavaWordApp {
    public static void main(String[] args) {
        //단어장을 시작하는 프로그램입니다
        Scanner sc = new Scanner(System.in);
        System.out.println();
        
        //1.단어장 생성
        JavaWordBook myBook = new JavaWordBook();
        //2.단어 추가
        myBook.addWord(new JavaWord("public", "공용의", 1));
        myBook.addWord(new JavaWord("protected", "보호하는", 1));
        myBook.addWord(new JavaWord("keyword", "키워드", 1));
        myBook.addWord(new JavaWord("identifiers", "식별자", 2));
        myBook.addWord(new JavaWord("iterate", "반복하다", 3));
        myBook.addWord(new JavaWord("binary", "2진수의", 3));
        myBook.addWord(new JavaWord("application", "응용프로그램", 2));
        myBook.addWord(new JavaWord("private", "개인적인", 2));


        myBook.wordAllPrint();

        //3.단어 조회
        //1)영어단어 입력하면 찾아주기
        String findword ="";// sc.nextLine();
        System.out.println("< "+findword+" > 조회 결과: "+myBook.searchWord(findword));

        //2)List<JavaWord> searchWordByLevel(int level) : 레벨로 조회하기
        List<JavaWord> list =myBook.searchWordsByLevel(2);
        myBook.wordListPrint(list);
        
        //4.단어 삭제
        String rvWord ="";
        myBook.removeWord(rvWord);

        // int menu =sc.nextInt();
        // switch (menu) {
        //     case 1:
                
        //         break;

        //     case 2:
                
        //         break;

        //     case 3:
                
        //         break;

        //     case 4:
                
        //         break;
        
        //     default:
        //         break;
        // }
    }
    
}
