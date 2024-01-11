package collection.day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class C05MapExample {

    /* 
     * Map<K,V> : key 값으로 value를 가져오기
     *            key 는 중복된 값을 가질 수 없다. key와 value 모두 순서 X
     *            맵에 입력한 순서대로 접근해야 한다면 LinkedHashMap
     *            또는 정렬(key 기준)된 방식으로 접근해야한다면 TreeMap
     * Map 구성요소 : key, value 중에서 key는 Set 특성을 갖고 있다
     * 
     * 
     */
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스");  //key가 "tw"인 value를 '수정'
        map.put("js", "뉴진스");
        System.out.println("~~~~map의 get 메소드 테스트~~~~");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);

        while (true) {
            System.out.print("찾을 값에 대한 Key 입력하시오 >>>> ");
            String key = sc.nextLine();
            if(key.equals("end")) break; //end 입력하면 while 종료
            System.out.println("당신이 원하는 key의 값: "+map.get(key));
        }
        
        System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");    //key 값으로 반복자를 생성
        System.out.println("\t map.keySet(): "+map.keySet());
        Iterator<String> iterator = map.keySet().iterator();
        int cnt =0;
        while(iterator.hasNext()) {
            String temp =iterator.next();
            System.out.println(String.format("count %d , key: %s , value: %s", 
                                                                                cnt++,              
                                                                                temp,               //key
                                                                                map.get(temp)));    //value
        }
        System.out.println("~~~~ for 반복자를 이용한 set 의 값 가져오기 ~~~~");

        cnt=0;
        for (String key : map.keySet()) 
            System.out.println(String.format("count %d , key: %s , value: %s",cnt++,key,map.get(key))); 
            
    }//main
}//class
