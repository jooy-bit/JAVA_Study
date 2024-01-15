package collection.day11;

import java.util.ArrayList;
import java.util.List;
import collection.myapp.JavaWord;

public class JavaWordApp_V2 {
    /* 
     * 메소드 만드는 연습
     * 검색 메소드, PRINT 메소드 리펙토링(refactoring)
     * 
     */

    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다
     private List<JavaWord> words =new ArrayList<>();
    public static void main(String[] args) {
        //프로그램 실해하는 객체 생성하고
        //          (메소드로 기능을 분리할 때 main이 호출하는 static을 없애기 위함)
        //          start 메소드 프로그램 내용을 코딩
        JavaWordApp_V2 app =new JavaWordApp_V2();
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
                    searchWordBy(); 
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
       words.add(new JavaWord("public", "공동의", 1));
       words.add(new JavaWord("private", "사적인", 1));
       words.add(new JavaWord("iterator", "반복자", 3));
       words.add(new JavaWord("appication", "응용프로그램", 2));
    }


    private void removeWord() {
        System.out.println("\t :: 단어 삭제합니다 ::");
        System.out.print("삭제하실 단어를 영문으로 입력하세요._");
        String rvEng =System.console().readLine();
        boolean isFind = false;
        for (int i = 0; i < words.size(); i++) {        //for(JavaWord w : words) ->오류 words의 변화로 오류가 생김
            if(words.get(i).getEnglish().equals(rvEng)){ 
            isFind= true;
            System.out.println("단어를 찾았습니다>>> " +words.get(i));
            System.out.print("삭제하려면 엔터, 취소는 n 을 눌러주세요.");
            if (System.console().readLine().equals("n")) 
                continue;
            }else{words.remove(i);
                i--;
            }
            //삭제 후 다음 인덱스는 하나 빼야함
        if (isFind=false)System.out.println("찾는 단어가 단어장에 없습니다. 추가해주세요.");
    }
}



    //새로운 검색 메소드 정의
    // 1. 단어 검색 : 첫 번째로 일치하는 결과만 리턴
    // 메소드 인자를 입력 데이터로 하여 메소드의 코드가 실행되고 결과는 출력으로 리턴
/*     private JavaWord searchFirstWord(String english){
        for(JavaWord word : words){
            if (word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english와 같은 word 리턴
                
            }
        }
        return null;                //찾는 english 단어 없으면 for문이 리스트 모두 반복 후 종료 .null 리턴
    } */




    // 2. 단어 검색 : 검색하는 단어와 일치하는 결과 모두 리턴
    private List<JavaWord> searchAllWord(String english){
        List<JavaWord> list = new ArrayList<>();                //검색 결과 저자하는 리스트
        for(JavaWord word : words){
            if (word.getEnglish().equals(english)) {
                list.add(word);                                 //일치하는 단어를 만날 때마다 저장
            }
        }return list;
    }


    private void searchWordBy(){
        System.out.println("단어를 검색합니다(1.영단어 검색 2.레벨 검색)");
        String find = null;
        List<JavaWord> list = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.print("검색할 단어를 영문으로 입력하세요._");
                find =System.console().readLine();
                list = searchAllWord(find);
                break;
            case "2":
                System.out.print("검색할 레벨을 숫자로 입력하세요._");
                int level= Integer.parseInt(System.console().readLine());
                list = searchAllWord(level);
                break;
        
            default:
            System.out.println("1,2만 입력하세요");
                break;
        }
        System.out.println();
        if (list.size()==0) System.out.println();
            else printWordList(list);
    }

    private List<JavaWord> searchAllWord(int level){
        List<JavaWord> list = new ArrayList<>();                //검색 결과 저자하는 리스트
        for(JavaWord word : words){
            if (word.getLevel()==level) {
                list.add(word);                                 //일치하는 단어를 만날 때마다 저장
            }
        }return list;
    }











    //리스트에 동일한 단어가 2번 저장되었다면?  
    //리스트에 없는 단어를 조회한다면?
    private void searchWord() {
        System.out.println("\t :: 단어 검색합니다 ::");
        System.out.print("찾으시는 단어를 영문으로 입력하세요._");
        String find =System.console().readLine();
        List<JavaWord> results = searchAllWord(find);
        if (results.size()==0) {System.out.println("찾는 단어 없어요");
        }else{printWordList(results);

        }
        //  1. 단어  1개 리턴할 때
    // JavaWord word = searchFirstWord(find);
    //    if(word!=null){
    //             System.out.println("검색 결과: "+word.getEnglish());
    //             System.out.println(String.format("%20s %20s %20s", "ENGLISH","KOREAN","LEVEL"));
    //             System.out.println(String.format("\t     %-20s  %-10s \t%4s", word.getEnglish(),word.getKorean(),word.getLevel()));
    //             //return; //단어 한개 찾으면 searchWord 메소드 종료
    //     }else{
    //         System.out.println("찾는 단어가 단어장에 없습니다. 추가해주세요.");
    //     //System.out.println("찾는 단어가 단어장에 없습니다. 추가해주세요.");
    // }       
    //  2. 단어 2개 리턴할 때

}
    

    //출력메소드    : 출력할 여러개의 JavaWord 객체를 전달받아 이쁘게 화면에 print
    private void printWordList(List<JavaWord> list){
        for (JavaWord word : list) {
            System.out.println(String.format("\t     %-20s  %-10s \t%4s", word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }


    private void listWord() {
        System.out.println("\t :: 단어 목록 출력합니다 ::");
        System.out.println(String.format("%20s %20s %20s", "ENGLISH","KOREAN","LEVEL"));
        System.out.println("~".repeat(70));
        printWordList(words);
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
