package collection.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//JavaWord 여러개를 저장할 클래스
//조회기능에 유리한 Map을 사용
public class JavaWordBook {
    //굳이 List 대신 Map 을 사용한 이유 : 조회를 편하게 하려고
    //조회 이외에는 특히 출력 등은 Map.values()로 values값만 사용하고 있음
    private Map<String, JavaWord>wordBook;
    //key : 영단어. key 값은 중복이 안되고 순서가 없다
    //value : JavaWord (영어,한글,레벨)
    public JavaWordBook(){
        this.wordBook = new TreeMap<>(); //key 값인 영단어 순으로 정렬해 접근
    }

    //getter
    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }

    //단어 추가
    public void addWord(JavaWord word){
        this.wordBook.put(word.getEnglish(),word);
  
    }
    
    //단어 조회
    public JavaWord searchWord(String english){
        return this.wordBook.get(english);

    }
    
    //단어 삭제
    public void removeWord(String english){
        this.wordBook.remove(english);

    }

    //단어장 전체 출력
    public void wordAllPrint(){
        List<JavaWord> all = new ArrayList<>(this.wordBook.values());
        wordListPrint(all);
    }
       
       
        // for (String  english : wordBook.keySet()) { 
        //     System.out.println(wordBook.get(english));
        // }
    //인자로 전달된 list 출력
    public void wordListPrint(List<JavaWord>list){
        System.out.println("~".repeat(20)+"~ 단어장 ~"+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t     %s", "<English>","<Korean>","<Level>"));
        for (JavaWord word : list) {
            System.out.println(String.format("%-15s %-15s\t%d", word.getEnglish(),word.getKorean(),word.getLevel()));
            
        }
    }
    public void searchWordsByLevel(int level){
        List<JavaWord> results = new ArrayList<>();
        for(JavaWord word : this.wordBook.values()){
            if (word.getLevel()==level) ;
            //return results.add(word);
        }
    }

}//class
