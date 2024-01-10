package object.day9;

import java.util.Arrays;

public class C22MySlortTest {
    public static void main(String[] args) {
        int[] numbers ={67,34,65,89,54};
        System.out.println("초기 numbers: "+Arrays.toString(numbers));
        //오름차순 a-Z 작은거부터 정렬
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i++; j < numbers.length; j++) {
                //비교 조건과 맞지 않으면 numbers[i]와 numbers[j]를 교환하기
                if(numbers[i]<numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
                System.out.println(String.format("중간 상태 : i = %d, j = %d 배열 : %s",i,j,Arrays.toString(numbers)));
            }        
        }
        System.out.println("오름차순 정렬 후 numbers= "+Arrays.toString(numbers));



        //내림차순 Z-a 큰거부터 정렬
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i++; j < numbers.length; j++) {
                //비교 조건과 맞지 않으면 numbers[i]와 numbers[j]를 교환하기
                if(numbers[i]>numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
                System.out.println(String.format("중간 상태 : i = %d, j = %d 배열 : %s",i,j,Arrays.toString(numbers)));
            }        
        }
        System.out.println("내림차순 정렬 후 numbers= "+Arrays.toString(numbers));
    }
}
