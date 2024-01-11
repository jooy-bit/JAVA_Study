package collection.day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {

    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("momo",23));
        list.add(new Member("nana",22));
        list.add(new Member("momo",25));
        list.add(new Member("dahy",21));
        list.add(new Member("sana",26));
            //hashcode,equals 메소드 재정의하기 before & after를 비교
            //컴파일어는 객체의 1)hashCode 같으면 2)equels 검사 -> 둘다 통과하면 동일 객체로 결정
            //                              L remove, indexOf메소드에 동일 객체 검사 할 때 사용
        System.out.println("현재 리스트 내용: "+list);
        list.remove(new Member("momo", 23));
        System.out.println("삭제된 리스트 내용: "+list);

        System.out.println("특정 멤버 조회: "+list.indexOf(new Member("momo",25)));
    
        //new Member("momo",23)에서 인스턴스 필드값이 같다고 동일한 객체가 아니다
        //remove, indexOf 등의 메소드는 동일한 객체를 찾아서 삭제하거나 조회한다
        //참고) String은 문자열 리터럴이 같으면 주소가 같다. 불변 객체
        //일반적으로 만들어진 클래스는 hashcode로 메모리 참조 위치가 결정된다
        //                          인스턴스 필드내용이 같으면 hashcode를 동일하게 만들도록 재정의한다
    
       list.sort(new Comparator<Member>() {
        @Override
        public int compare (Member o1, Member o2) {
                return (o1.getAge() - o2.getAge());
        }
    });
       System.out.println("정렬 후: "+list);
       //정수,실수,문자열 타입은 list.sort(null);로 오름 차순 정렬 
       //그 외에는 Comparator를 구현
       
       //List static 메소드
       // L 테스트용 리스트 만들 때 많이 사용/ 불변객체
        List<String> names = List.of("momo","dahy","nana","sana");
        System.out.println("name="+ names);
        //names.add("xxyyzz");            //Immutable(불변의)Collections 오류

        
    }//main
    
}//class
