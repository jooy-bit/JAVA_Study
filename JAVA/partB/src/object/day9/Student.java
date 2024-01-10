package object.day9;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age= age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Students [name = %s , age = %d ]", this.name,this.age);
    }
    /* 
     * Member Class compareTo 문제점 : 
     * 비교 기준 또는 정렬 방법(오름, 내림)을 변경하려면 클래스 내부의 compareTo 메소드 구현 안 return을 변경해야해 Member를 사용한 타프로그램에 영향을 줌
     * 
     */

}
