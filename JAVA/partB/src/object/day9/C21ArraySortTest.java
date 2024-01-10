package object.day9;

import java.util.Arrays;
import java.util.Comparator;

/* 




 
 */
public class C21ArraySortTest{
    public static void main(String[] args) {
        int[] numbers = {67,34,77,89,82};
        System.out.println("원본 numbers= "+ Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("정렬 후numbers= "+ Arrays.toString(numbers));
        
        
        String[] names ={"momo","nayeon","dahyeon","Zewi","Bio"};
        System.out.println("원본 names= "+ Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("정렬 후 names= "+ Arrays.toString(names));
        
        //Arrays.sort( 배열 변수 ): 기본 배열, String 배열의 오름 차순 정렬 가능
        // -> 내림 차순 정렬 또는 다른 참조타임에 대한 정렬은 메소드 두번쨰 인자로 정렬 기준 공식을 인터페이스로 전달합니다.

        //순차정렬 알고리즘 : 가장 단순한 알고리즘
        
        //내림차순 정렬 - comparator는 <> 제너릭타입에 기본형을 사용 못합니다
        //              기본형은  Wrapper 클래스를 사용.
        Integer[] numbers2 = {67,34,77,89,82};//대입문 또는 수식에서 Integer 타입과 int 타입 사이의 캐스팅은 자동
        /* Arrays.sort(numbers2,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
            
        }); */
        
        Arrays.sort(numbers2,(o1, o2)-> {return o2-o1;});

        
        System.out.println(Arrays.toString(numbers2));
    }
}