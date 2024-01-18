package etc.day15;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * InnerMyCalendar
 */
public class InstanceTest {

    public static void main(String[] args) {
        MyCalendar my1 = MyCalendar.getInstance();
        // MyCalendar my2 = new MyCalendar();
        // MyCalendar my3 = MyCalendar.object;
        YourCalendar you1 = YourCalendar.of("2024", "03");
    }
    
}
//main메소드는 1개파일에 하나만 있어야 한다 //public 클래스도 1개 파일에 하나만 있어야 한다
// 위의 2가지 지키고 1개 파일 클래스는 여러개 만들 수 있다.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Member {
    private String name;
    private int age;
    private int point;
    //커스텀 생성자 //기본생성자 //getter //setter //toString 재정의 //hashcode 와 equals 재정의
}

class MyCalendar {
    private static MyCalendar object = new MyCalendar();

    private MyCalendar() {
    }

    public static MyCalendar getInstance(){
        return object;  //미리 만들어진 클래스 타입의 객체를 리턴
    }
}

class YourCalendar{
    private String month;
    private String day;
    private YourCalendar(){}
    public static YourCalendar of(String month,String day){
        YourCalendar result = new YourCalendar();
        result.month = month;
        result.day = day;
        return result;
    }
    public String getDay(){
        return day;
    }
    public String getMonth() {
        return month;
    }

}
