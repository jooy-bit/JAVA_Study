package collection.day12;

import java.util.List;
import collection.myapp.JavaWord;
/* 
 * 객체 지향 프로그램은 최대한 객체로 분리시켜서 실행되는 환경에 독립적이 되도록 합니다
 */

//private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다
public class JavaWordApp_V3 {
     private JavaWordList words =new JavaWordList();
    public static void main(String[] args) {
        JavaWordApp_V3 app =new JavaWordApp_V3();
        app.start();
    }

    private void start(){
        words.initialize();
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

    private void addWord() {
        System.out.println("\t :: 단어 등록합니다 ::");
        System.out.print("영어 단어 입력하세요. _");
        String english = System.console().readLine();
        System.out.print("한글 의미 입력하세요. _");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요. (1:초급 2:중급 3:고급)_");
        int level = Integer.parseInt(System.console().readLine());
        words.add(new JavaWord(english, korean, level));
    }//add

    private void listWord() {
        System.out.println("\t :: 단어 목록 출력합니다 ::");
        System.out.println(String.format("%20s %30 %20s", "ENGLISH","KOREAN","LEVEL"));
        words.print();
    }//list

    private void searchWordBy(){
        System.out.println("단어를 검색합니다(1.영단어 검색 2.레벨 검색)");
        List<JavaWord>list = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.print("검색할 단어를 영문으로 입력하세요._");
                list= words.searchAllByEnglish(System.console().readLine());
                break;
            case "2":    
                System.out.print("검색할 레벨을 입력하세요._");
                list= words.searchAllByLevel(Integer.parseInt(System.console().readLine()));
                break;
            default:    
            System.out.println("1,2만 입력하세요");
                break;
        }        
        if (list.size()==0) 
            System.out.println("찾는 단어가 단어장에 없습니다");
            else JavaWordList.print(list);
    }//search        

    private void removeWord() {
        System.out.println("\t :: 단어 삭제합니다 ::");
        System.out.print("삭제하실 단어를 영문으로 입력하세요._");
        String removeEng =System.console().readLine();
        words.searchFirstByEnglish(removeEng);
        int num =words.indexOfWord(removeEng,0);
        System.out.println("단어를 찾았습니다>>> " +num);
        if (num==-1) {
            System.out.println("찾는 단어가 단어장에 없습니다. 추가해주세요.");
            return;
           }
        while (num!=-1){
            System.out.println("삭제할 단어 - "+words.getWord(num));
            System.out.print("삭제하려면 엔터, 취소는 n 을 눌러주세요.");
            if (!System.console().readLine().equals("n")) {
                words.remove(num);
                System.out.println("삭제완료!");
                num--;
            }//if
        }//while
    }//remove

}//class