package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("트와이스");
        set.add("아이브");
        set.add("잇지");
        set.add("뉴진스");
        set.add("블랙핑크");
        set.add("트와이스");
        System.out.println("~~~~~HashSet~~~~~");
        System.out.println("set: "+set);
        System.out.println("set.size(): "+set.size());
        System.out.println("");
        for (String temp : set) {
            System.out.println("\t set 요소: "+temp);            
        }
        //for (int i = 0; i < args.length; i++) {      } //fori 형식

        Set<String> set2 = new LinkedHashSet<>();   
        //본래 Set은 무작위 접근 
        //Linked는 다음 입력데이터의 참조값을 저장하여 입력순서대로 접근
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("소녀시대");
        set2.add("블랙핑크");
        set2.add("트와이스");
        System.out.println("~~~~~LinkedHashSet~~~~~");
        System.out.println("set2: "+set2);
        System.out.println("set2.size(): "+set2.size());
        
        Set<String> set3 = new TreeSet<>();
        //이진트리 알고리즘을 이용해 데이터를 정렬된 방식을 접근
        set3.add("트와이스");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("소녀시대");
        set3.add("블랙핑크");
        set3.add("트와이스");
        System.out.println("~~~~~TreeSet~~~~~");
        System.out.println("set3: "+set3);
        System.out.println("set3.size(): "+set3.size());
    }
}
/* 
 * Set: 수학시간에 배우 집합
 * 순서(인덱스) X
 * 중복값 X
 * Map 구성요소 : key, Value 중에서 Key는 Set 특성을 지님
 */
