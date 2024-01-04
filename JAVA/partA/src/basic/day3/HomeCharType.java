package basic.day3;
/*
:::: [과제-2024/01/03 22시까지 제출] 문자열을 구성하는 문자의 종류 분석하기 ::::
1) 문자열을 임의로 저장합니다. 예시 : "Hello* Java Hi* Linux~~~" 

2) 1)번의 문자열을 구성하는 문자 하나하나가  '대문자' '소문자' '숫자' '기호' 중 어떤 종류의 문자인지 검사합니다.

3) 2)번의 검사를 통해서 문자열을 구성하는 문자의 종류와 개수를 구하여 출력합니다.
변수명 :      대문자의 갯수 upperCount , 
      소문자의 갯수 lowerCount, 
      숫자의 갯수 numberCount, 
      기호의 갯수 symbolCount 

출력 예시 :  
------------------------------------------------------------
문자열 : Hello* Java Hi* Linux~~~
문자 종류 : 대문자 4개, 소문자 12개, 숫자 0개, 기호 8개  


 */
public class HomeCharType {
    public static void main(String[] args) {
        
        int upperCount = 0; //대문자의 갯수  65- 90
        int lowerCount = 0; //소문자의 갯수  97- 122
        int numberCount = 0; //숫자의 갯수   48-57
        int symbolCount = 0; //기호의 갯수 


        String message = "Hello* Java Hi* Linux~~~";
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            if (temp>64&&temp<91) upperCount++;
            else if (temp<123&&temp>96) lowerCount++; 
            else if (temp<58&&temp>47) numberCount++;
            //다국어가 아닐 경우만 가능!!
            else symbolCount++;
            //else if (temp<=64&&temp>=91||temp>=123&&temp<=96||temp>=58&&temp<=47) symbolCount++;
        }
        System.out.println("문자열 : "+ message + "\n문자종류 : 대문자 " + upperCount + " 개 "+ "소문자 " + lowerCount + " 개 " + "숫자 " + numberCount +" 개 " + "기호 "+ symbolCount + " 개");

        
        
        
        upperCount = 0; //대문자의 갯수  65- 90
        lowerCount = 0; //소문자의 갯수  97- 122
        numberCount = 0; //숫자의 갯수   48-57
        symbolCount = 0; //기호의 갯수 
        
        
        //Character class 
            //Character 클래스는기본 데이터 타입의 값을 객체 형식으로 표현하기 위해 사용
        String str = "Hello* Java Hi* Linux~~~";
        for(char c : str.toCharArray()){
            if (Character.isUpperCase(c)) upperCount++;
            else if(Character.isLowerCase(c)) lowerCount++;
            else if(Character.isDigit(c)) numberCount++;
            else symbolCount++;
        }
        System.out.println("문자열 : "+ message + "\n문자종류 : 대문자 " + upperCount + " 개 "+ "소문자 " + lowerCount + " 개 " + "숫자 " + numberCount +" 개 " + "기호 "+ symbolCount + " 개");

        

    }

}
