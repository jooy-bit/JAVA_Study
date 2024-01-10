package object.day9;

import java.util.Arrays;

public class C24MemberCompareTest {


    //Member 객체를 비교하고 Member 배열 정렬도 할 수 있다.
    public static void main(String[] args) {
        Member momo = new Member("momoo", 23);
        Member nana = new Member("nana", 20);
        Member dahy = new Member("dahyeon", 21);
        Member sana = new Member("sana", 22);

        System.out.println("모모와 나나를 비교(나이 기준)   :   ");
        System.out.println("\t"+momo.compareTo(nana)/* +"-> 양수이면 momo가 nana보다 나이가 많습니다" */);

        Member[] twice = new Member[4];
        twice[0] = momo; twice[1] = nana; twice[2] = dahy; twice[3] = sana;

        System.out.println("초기 twice 배열 : "+Arrays.toString(twice));
        Arrays.sort(twice); //배열 요소 Member객체가 comepareTo 메소드가 가지고 있어서 가능
        System.out.println("초기 twice 배열 : "+Arrays.toString(twice));
    }

}