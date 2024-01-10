package object.day6;
//코드를 클린코드로 바꾸기
public class MyClass3 {
    //선언
    //인스턴스 필드: 클래스 내부에서 사용가능한 전역변수
    private String field1;
    private int field2;
    private double[] field3;

    //getter
    public String getField1(){
        return this.field1;         //this - 현재 자신 객체를 나타내는 변수
    }
    public int getField2(){
        return this.field2;
    }

    
    //setter
    public void setField1(String field1){ //인자로 쓰인 매개변수: setField1 메소드의 지역변수
        this.field1 = field1; //현재객체의 field1값에 인자 field1대입
    }
    
    public void setField2(int field2){
        this.field2 = field2;
    }

    public void serField3(double[] field3){
        this.field3 =field3;
    }
    

}
