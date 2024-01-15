package collection.day12;
import java.util.List;
import collection.myapp.JavaWord;
/* 
 * 자바 단어장 클래스는 아래의 추상 메소드를 꼭 구현해야 합니다.(기능 또는 규칙)
 */
public interface Wordlist {
    //최대 단어개수100개를 설정한다면
    //public static final 
    int MAX_LENGTH =100;
    //추상메소드 정의 - 구현 내용은 클래스의 특징에 따라 정의 됩니다.
   JavaWord getWord(int i);
   List<JavaWord> list();
   void add(JavaWord word);
   int indexOfWord(String english, int position);
   JavaWord remove(int index);
   List<JavaWord> searchAllByEnglish(String english);
   void print();
//if) 이 후 구현에 적용하고 싶은 메소드가 있다면 default 키워드로 정의
    default List<JavaWord> search(Object object){
        return null;
    }
}
