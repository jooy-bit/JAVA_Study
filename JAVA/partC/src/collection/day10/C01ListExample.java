package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<>();
        //

        strlist.add("트와이스"); //index 0
        strlist.add("잇지");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스");
        strlist.add("아이브");  //index 5

        System.out.println("문자열 LIST strlist size"+strlist.size());      //답은 6
        System.out.println("\n 데이터 추가");
        strlist.add("르세라핌");
        System.out.println("항목 추가 후 리스트"+strlist); //ArrayList 클래스의 toString메소드 실행

        System.out.println("\n 데이터 삭제");
        strlist.remove("원더걸스");     //remove 메소드 오버로딩
        strlist.remove(1);          //        :  메소드 인자 타입이 int와 String(요소 타입) 2가지로 동작
        System.out.println("항목 삭제 후 리스트"+strlist);
        
        //아래 2개 메소드 비교
        strlist.add(2,"?????");             //중간 삽입
        System.out.println("항목 변경 후 리스트"+strlist);
        strlist.set(2,"!!!!");              //수정
        System.out.println("항목 변경 후 리스트"+strlist);
        
        System.out.println("\n 특정 인덱스 위치의 요소값 가져오기");
        System.out.println("strlist.get(0)= "+strlist.get(0));
        System.out.println("strlist.get(3)= "+strlist.get(3));
        // System.out.println("strlist.get(9)= "+strlist.get(9));//error Index 9 out of bounds for length 6
        
        //addAll
        List<String> sublist = new ArrayList<>();
        sublist.add("투바투"); sublist.add("세븐틴");
        strlist.addAll(strlist);
        strlist.addAll(sublist);
        System.out.println("\n strlist.addAll(strlist): "+strlist);
        strlist.add("아이브");
        System.out.println("\n strlist.add(중복값): "+strlist);
        
        //조회 기능 -리스트에서 요소 찾기
        //contains
        strlist.contains("레드벨벳");
        System.out.println("strlist.contains(\"레드벨벳\") : "+strlist.contains("레드벨벳"));
        
        //indexOf
        strlist.indexOf("아이브");
        System.out.println("strlist.indexOf(\"아이브\") : "+strlist.indexOf("아이브"));
        
        //lastIndexOf
        strlist.lastIndexOf("르세라핌");
        System.out.println("strlist.lastIndexOf(\"르세라핌\") : "+strlist.lastIndexOf("르세라핌"));
        
        
        System.out.println("\n\n리스트에서 항목 찾기");
        System.out.println("\t 리스트에 처음 `아이브` 어디 있음? " + strlist.indexOf("아이브"));
        System.out.println("\t 리스트에 마지막 `아이브` 어디 있음? " + strlist.lastIndexOf("아이브"));
        System.out.println("\t 리스트에 `뉴진스` 있음? " + strlist.contains("뉴진스"));
        System.out.println("\t 리스트에 `뉴진스` 어디 있음? " + strlist.indexOf("뉴진스"));
        
        
        strlist.removeAll(sublist);
        System.out.println("항목 변경 후 리스트"+strlist);
        // strlist.clear();
        // System.out.println("항목 변경 후 리스트"+strlist);
        // strlist.sort(); //정렬

        
    }//main
    
}
/* 
 * List 구현 클래스 특징 :배열처럼 인덱스를 갖습니다. 인덱스가 있다는 것은 데이터의 순서가 있다는 의미
 *                       배열에 없는 '삭제 기능'이 있다. 
 *                       그 외에도 조회 관련 기능 등 조작과 조회를 다양하게 할 수 있다.
 */