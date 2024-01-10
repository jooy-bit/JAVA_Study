package object.day9;

import java.util.Arrays;
import java.util.Comparator;

//Arrays.sort 메소드에 두번째 인자로 Comparator 인터페이스 타입 객체를 전달하면 비교 기준과 정렬 방법을 실행시점에서 결정된다.
public class C25StudentCompareToTest {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("장모모", 23); 
        students[1] = new Student("박나연", 22); 
        students[2] = new Student("김다현", 24); 
        students[3] = new Student("사나", 21); 
        
        System.out.println("초기 students 배열 : "+Arrays.toString(students));
        //Arrays.sort(students); //오류: students 오브젝트를 Comparable이 아니다

        Arrays.sort(students,new Comparator<Student>() {
            //한번만 사용할 comparator는 변수 선언하지 않고 바로 인자로 전달.
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() -o2.getAge();//o1(왼쪽), o2(오른쪽) 이며 오/내림 상관없이 교환을 안해도 되는 경우를 음수값으로 리턴한다.
            }                                   // sort 메소드 정렬 알고리즘은 비교결과 음수가 리턴되면 교환하지 않고 양수리턴 시 교환한다.
        });
        System.out.println("나이 오름차순 정렬 후 students 배열 : " + Arrays.toString(students));

        //ageDecending
        Arrays.sort(students,( o1, o2)-> {return o2.getAge() -o1.getAge();}); //내림차순 o1>o2이 되어야 한다. o2-o1<0 이면 교환 X.

        //위 람다식은 Comparator 구현 클래스 정의: 추상메소드 1개 Compare 메소드 인자는  Student 타입 o1, o2 // 메소드 실행 리턴은 {몸통}에 작성
        System.out.println("나이 내림차순 정렬 후 students 배열 : " + Arrays.toString(students));
        
        //nameAscending
        Arrays.sort(students,(o1,o2)-> { return o1.getName().compareTo(o2.getName());});

        System.out.println("이름 오름차순 정렬 후 students 배열 : " + Arrays.toString(students));
        
        
        //nameDecending
        Comparator<Student> nameDecending = (o1, o2) -> {
                return o2.getName().compareTo(o1.getName());
            };
        Arrays.sort(students,nameDecending);
        System.out.println("이름 내림차순 정렬 후 students 배열 : " + Arrays.toString(students));
    }
}
