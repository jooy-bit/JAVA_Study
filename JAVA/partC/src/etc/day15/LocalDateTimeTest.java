package etc.day15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println("\n1.현재 날짜와 시간을 구하여 출력하기");
        LocalDate currenDate = LocalDate.now();         //now()가 new 연산 대신함
        System.out.println("\tLocalDate 현재 날짜: "+currenDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("\tLocalTime 현재 시간: "+currentTime);
        LocalDateTime currDateTime = LocalDateTime.now();   // 1/10억(ns)까지 구해준다
        System.out.println("\tLocalDateTime 현재 날짜와 시간: "+currDateTime);
        System.out.println("\n"+"-".repeat(80));
        System.out.println("\n2.특정 날짜와 시간을 지정해서 객체를 생성합니다");    
        LocalDate myBitrh = LocalDate.of(2000,4,11);    //of() 메소드 : 객체를 생성하고 값을 초기화 한다.
        System.out.println("\tLocalDate.of(2000,04,11): "+myBitrh);
        LocalTime myBirth_time = LocalTime.of(8, 27);
        System.out.println("\tLocalTime.of(8,27) : "+myBirth_time);
        LocalDateTime myBirth_dateTime = LocalDateTime.of(2000, 4, 11, 8, 27, 34);
        System.out.println("\tLocalDateTime.of(2000, 4, 11, 8, 27, 34) : "+myBirth_dateTime);
        System.out.println("\n"+"-".repeat(80));

        //java.time 패키지에 다른 클래스 테스트
        System.out.println("3.날짜 사이의 간격 계산하기");
        System.out.println("\t내가 태어난지 --년 --월 --일이 지났는지");
        Period between = Period.between(myBitrh, currenDate);
        System.out.print(between.getYears()+"년 ");
        System.out.print(between.getMonths()+"개월 ");
        System.out.println(between.getDays()+"일");
        System.out.println("\n"+"-".repeat(80));
        System.out.println("\n4.날짜 사이의 간격 계산하기(단위: 년,개월,일)");
        System.out.println("\t내가 태어나서 년(개월, 일)이 지났습니다");
        System.out.println(ChronoUnit.DAYS.between(myBitrh, currenDate)+" 일");
        System.out.println(ChronoUnit.MONTHS.between(myBitrh, currenDate)+" 개월");
        System.out.println(ChronoUnit.YEARS.between(myBitrh, currenDate)+" 년");
        System.out.println("\n"+"-".repeat(80)+"\n");
        System.out.println("5. 내 생일로부터 10000일 이후 날짜는?");
        LocalDate day10000 = myBitrh.plusDays(10000);
        System.out.println("\t10000일 이후 날짜: "+day10000);
        System.out.println("\n"+"-".repeat(80)+"\n");
        System.out.println("6. 오늘 날짜로부터 10000일 이전 날짜는?");
        LocalDate before10000 = currenDate.minusDays(10000);
        System.out.println("\t10000일 이전 날짜: "+before10000);
        System.out.println("\n"+"-".repeat(80)+"\n");
        System.out.println("7. 오늘 날짜로부터 3일 이전, 이후 날짜는?");
        System.out.println("\t3일 이후: "+currenDate.minusDays(3));
        System.out.println("\t3일 이전: "+currenDate.plusDays(3));
        System.out.println("\n"+"-".repeat(80)+"\n");
        System.out.println("8. 날짜의 출력 패턴 설정하기");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY년 MM월 DD일");  //시간 hh 분 mm 초 ss 밀리세컨즈 SSS
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY년 MM월 DD일 hh시 mm분 ss초");  //시간 hh 분 mm 초 ss 밀리세컨즈 SSS
        System.out.println("\t"+currenDate.format(formatter));
        System.out.println("\t"+currDateTime.format(formatter2));

    }//
}//
