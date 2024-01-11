package collection.day10;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;;

public class C06TodayMenuVote {
    //Map 연습
    public static void main(String[] args) {
        
        String menu = "치킨, 스파게티, 곱창, 불고기, 돼지고기";
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("치킨", 0);
        map.put("스파게티", 0);
        map.put("곱창", 0);
        map.put("불고기", 0);
        map.put("돼지고기", 0);

        System.out.println("오늘 메뉴 투표합니다");
        System.out.println("메뉴: "+ menu);
        Scanner sc = new Scanner(System.in);

 


        while (true) {
            System.out.print("영문 메뉴 이름 입력 >>>");
            String key = sc.nextLine();
            if(key.equals("end")){ 
                System.out.println("투표가 종료되었습니다.");
                System.out.println(map.entrySet());
                System.out.println("최다 득표 결과");
                // Comparator<Entry<String,Integer>> comparator= (e1,e2)-> {return e1.getValue()-e2.getValue();};//아래랑 같은 식
                Comparator<Entry<String,Integer>>comparator = new Comparator<Entry<String,Integer>>() {
                    @Override
                    public int compare(Entry<String,Integer> e1,Entry<String,Integer> e2){
                        return e1.getValue()-e2.getValue();
                    }                    
                };
                Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),comparator); //Collections.max 가장큰값
                System.out.println("\t 메뉴이름: "+ maxEntry.getKey());
                System.out.println("\t 득표수 : "+maxEntry.getValue());
                break;}    
            if(map.containsKey(key)){
                int value= map.get(key);
                map.put(key, ++value);
                System.out.println(key+"에 투표하셨습니다");
            }else{
                System.out.println("투표에 없는 메뉴이군요. 추가 하겠습니다");
                map.put(key, 1);
                menu += ","+key;
            }
            
        }
        sc.close();
    }//main
    
}//class
