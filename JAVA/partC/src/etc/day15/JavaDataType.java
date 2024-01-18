package etc.day15;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
/* 
 * 자바에서 날짜 형식을 지원하는 클래스
 * 1)java.util 패키지의 Date,Calendar 클래스 : jdk1.1버전부터
 * 2)java.sql 패키지의 DAte,Timestamp 클래스 : jdk1.1버전부터 데이터베이스와 연동되는 타입
 * 3)java.time 패키지의  LocalDate, LocalTime, LocalDateTime 클래스 : jdk1.8버전부터
 *                  ㄴ 날짜, 시간과 관련된 많은 클래스들과 메소드를 제공
 */
public class JavaDataType {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        long now = System.currentTimeMillis();
        System.out.println("1. 현재시간을 1970년 1월 1일 0시기준으로 구합니다. 단위: ms(1/1000초)");
        System.out.println("\t현재 시간 : "+now+"ms");
        System.out.println("\t현재 시간 : "+df.format(now)+"ms");
        System.out.println("---현재 시간을 ms로 구하는 방식은 모든 프로그래밍언어에서 사용합니다.---");
        System.out.println("\n2. 약 54을 직접 ms로 계산해 봅시다");
        long oneday = 24*60*60*1000;
        long oneyear = 365*oneday;
        System.out.println("\t1일 24시간: "+df.format(oneday)+"ms");
        System.out.println("\t1년 365일: "+df.format(oneyear)+"ms");
        System.out.println("\t54년: "+df.format(54*oneyear)+"ms");
        System.out.println("\t55년: "+df.format(55*oneyear)+"ms");

        System.out.println("\n3. 날짜 클래스로 객체 생성합니다");
        System.out.println("java.utill.Date 클래스" + new Date());
        System.out.println("java.utill.Date 클래스 getTime" + new Date().getTime());
        System.out.println("------------------------------------------------");
        System.out.println("java.sql.Date 클래스 " + new java.sql.Date(54*oneyear));
        System.out.println("java.sql.Date 클래스 " + new java.sql.Date(new Date().getTime()));
        System.out.println("------------------------------------------------");
        System.out.println("java.util.Calendar 클래스 " + Calendar.getInstance());
        System.out.println("=> private 생성자이고 객체를 만들어 전달해주는 getInstance 메소드");

    }
}