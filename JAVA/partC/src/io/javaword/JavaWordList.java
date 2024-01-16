package io.javaword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import collection.myapp.JavaWord;
/**
 * JavaWordApp_V4 : 
 * 
 * JavaWordList : 단어장 객체를 생성할 떄 읽어올 단어장 파일을 꼭 전달해야 합니다. 단어장 파일의 데이터로 리스트를 초기화 했습니다.
 *
 * 이 프로그램이 다른 환경( 예, 웹브라우저 ) 에서 동작할 때 단어 1개, 단어장은 단어 여러개에 갖고 이를 대상으로 메소드를 명시하고 객체 생성이 가능하도록 하기 위함
 * 
 * 최후정리 : 자바 단어장 클래스에 적용될 인터페이스 생성
 */
public class JavaWordList implements Wordlist{
    private List<JavaWord> words;
    private String filePath;

    public JavaWordList(String filePath) {
        System.out.println("최대 저장 개수: "+ Wordlist.MAX_LENGTH);
        words = new ArrayList<>();
        this.filePath = filePath;
    }
    public void fileLoad() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while ((line=br.readLine())!=null) { 
                String[] temp = line.split(",");
                words.add(new JavaWord(temp[0].trim(), temp[1].trim(), Integer.parseInt(temp[2].trim())));
            }
        } catch (IOException e) {
            System.out.println("파일 입력오류: "+e.getMessage());
        }
    }
    

    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }

    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {
        if (words.size()==Wordlist.MAX_LENGTH) {
            System.out.println("단어장이 가득찼습니다. 새로 만들어주세요");
            return;
        }
        words.add(word);
    }

    @Override
    public int indexOfWord(String english,int position){
        for(int i=position;i<words.size();i++){
            if(words.get(i).getEnglish().equals(english))
                return i;       //찾으면 인덱스 리턴
        }   
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
        JavaWord word = words.remove(index);    //삭제한 데이터를 리턴합니다.
        return word;
    }

    //단어 1개 조회(여러개 일때는 처음 1개)
    public JavaWord searchFirstByEnglish(String english) {
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english 와 같은 word 리턴(메소드 종료)
            }
        }
        return null;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    //인스턴스 메소드 : 인스턴스 필드 words를 사용하여 작동
    @Override
    public void print(){
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    //static 메소드 : 인스턴스 필드를 사용하지 않고 메소드 인자를 받아 동작
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

   
   

}