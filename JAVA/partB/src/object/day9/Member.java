package object.day9;
/* 
 * 인터페이스 예시 - 비교 가능한 객체 만들기
 *                  - 1) Comparable 인터페이스 구현
 * 
 * Comparable<Member>는 <> 안 타입을 표시. 이런 방식을 제너릭타입
 *                      제너릭타입은 클래스 또는 인터페이스의 메소드에게 '타입'을 매개변수로 전달하기 위한 방식
 *                      이 때 타입이 실행시점에서 결정 되기 때문. 기본형은 Wrapper 클래스를 사용
 *                      Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달.
 * Comparable : 비교할 수 있는
 */
public class Member implements Comparable<Member> {
    private String id;
    private int age;


    public Member(String id,int age){
        this.id =id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
    //Comparable  인터페이스를 추상 compareTo 구현
    @Override
    public int compareTo(Member o) { //메소드의 인자 타입 Member는 <> 제너릭 타입과 같게 만들어집니다.
        //현재 객체 this를 인자로 전달되는 Member 객체와 비교
        //비교 기준은 요구사항에 따라 개발자가 정함.
        //if 나이로 한다면
        //return this.age - o.age; //오름차순
        //return o.age - this.age; //내림차순
        //if 이름으로 한다면
        // return this.id.compareTo(o.id); //오름차순
        return o.id.compareTo(this.id); //내림차순

        // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
        
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", age=" + age + "]\n";
    }

}
