package collection.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C03MemberListPrint {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("momo",23));
        list.add(new Member("nana",22));
        list.add(new Member("momo",25));
        list.add(new Member("dahy",21));
        list.add(new Member("sana",26));
        //toString 재정의된 출력이 아닌 직접 이름, 나이를 모두 출력
        System.out.println(String.format("%15s\t %15s", "name","age"));
        for (int i = 0; i < list.size(); i++) System.out.println(String.format("%15s\t %15d", list.get(i).getName(),list.get(i).getAge()));
    
    //컬렉션에서는 반복자(Iterator)로 데이터에 접급
    //반복자를 이용한 출
    Iterator<Member> iterator = list.iterator(); //list로 선언된 자료구조에 접근할 반복자 선언
    int count =0;
    while(iterator.hasNext()){          //반복자가 접근할 다음 데이터가 있으면 참
        Member temp = iterator.next();  //반복자가 다음 데이터를 가져옵니다
        System.out.println("\tcount="+count++ +", 요소="+temp);
    }
    
    //iterator 로 동작하는 for
    count =0;
    for (Member temp : list) System.out.println("\tcount="+count++ +", 요소="+temp);
    



    
    }//main
}//class
