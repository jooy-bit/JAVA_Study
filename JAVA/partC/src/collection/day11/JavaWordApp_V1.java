package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

public class JavaWordApp_V1 {
    /* 
     * 
     * 
     */

    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다
     private List<JavaWord> words =new ArrayList<>();
    public static void main(String[] args) {
        //프로그램 실해하는 객체 생성하고
        //          (메소드로 기능을 분리할 때 main이 호출하는 static을 없애기 위함)
        //          start 메소드 프로그램 내용을 코딩
        JavaWordApp_V1 app =new JavaWordApp_V1();
        app.start();
    }

    //프로그램 실행을 시작하는 메소드
    private void start(){
        initialize(); //초기화
        //단어 등록, 목록, 검색, 삭제 기능을 메뉴로 구현
        System.out.println("단어장 프로그램을 시작합니다"+"~".repeat(20));
        while (true) {
            System.out.println("\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 단어 프로그램 종료");
            System.out.print("\t 선택 >>> "); //메소드에 입력기능이 있을 때는 Scanner 관리가 불리
            int select = Integer.parseInt(System.console().readLine()); //키보드 입력 문자열 -> 정수
            //System.console() : 시스템의 콘솔(표준입출력장치) 객체를 리턴
            //.readLine() 입력메소드 실행

            switch (select) {
                case 1:
                    addWord();  //단어 등록 메소드 실행
                    break;

                case 2:
                    listWord();  //단어 등록 메소드 실행
                    break;
                    
                case 3: 
                    searchWord(); 
                    break;
                case 4: 
                    removeWord(); 
                    break;
                case 5: 
                    System.out.println("프로그램을 종료합니다."); 
                    System.exit(0);
                    break;  //main 종료
                
                default:
                System.out.println("잘못된 선택값입니다.");
                break;
            }//switch
        }//while end
    }//start class

    
    private void initialize() {
        // words 리스트 요소 몇개만 저장해서 초기화 테스트용
       words.add(new JavaWord("public", "공용의", 1));
       words.add(new JavaWord("private", "사적인", 1));
       words.add(new JavaWord("iterator", "반복자", 3));
       words.add(new JavaWord("appication", "응용프로그램", 2));
    }

    private void removeWord() {
       
    }

    private void searchWord() {
        // TO DO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchWord'");
    }
    private void listWord() {
        System.out.println("\t :: 단어 목록 출력합니다 ::");
        System.out.println(String.format("%20s %20s %20s", "ENGLISH","KOREAN","LEVEL"));
        for (JavaWord javaWord : words) {
            System.out.println(String.format("\t     %-20s  %-10s \t%4s", javaWord.getEnglish(),javaWord.getKorean(),javaWord.getLevel()));
        }
    }
    private void addWord() {
        System.out.println("\t :: 단어 등록합니다 ::");
        System.out.print("영어 단어 입력하세요. _");
        String english = System.console().readLine();
        System.out.print("한글 의미 입력하세요. _");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요. (1:초급 2:중급 3:고급)_");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
        //테스트 하면서 코드 분석
    }
    

        
    
}
