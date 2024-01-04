package basic.day1;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class ProbChangeMoney {
    public static void now(String[] args){SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
     Calendar c1 = Calendar.getInstance();
     String strToday = sdf.format(c1.getTime());
     System.out.println("Today=" + strToday);
    }
    

    public static void main(String[] args) {
               
        int myWon = 1000000;          //여행 경비 (100만원)
        double toYen;                   //환전한 엔화 값

        int cost;                       //여행 비용
        int myYen;                      //남은 여행 경비
        double toWon;                     //남은 경비 환전한 원화

        double yenTowonRate=9.29;       //1엔이 몇 원? 구매시
        double wonToYenRate=8.97;       //1원이 몇 엔? 판매시



        cost = 98760;
        myYen = 8882;
        toWon = myYen*wonToYenRate;
        toYen = myWon/yenTowonRate;
    
        System.out.println(
        "::: 한/일"+ "23.12.28" + "기준 환율 :::"+
        "\n살 때 1엔 = " + yenTowonRate + "원" +
        "\n팔 때 1엔 = " + wonToYenRate + "엔" +
        "\n"+

        "\n::: 원화를 엔화로 환전하기 :::"+
        "\n환전할 원화는 "+ myWon +"원 입니다."+
        "\n원화를 엔화로 바꿀 때 :  "+ toYen +"원 입니다."+
        "\n"+

        "\n::: 엔화를 원화로 환전하기 :::"+
        "\n일본에서 사용한 금액은 "+cost+"원 입니다."+
        "\n남은 엔화는 열마인가요? (정수) " + myYen + "엔"+
        "\n원화를 엔화로 바꿀 때 :  "+toWon+"원 입니다."
        );
    
    }
}