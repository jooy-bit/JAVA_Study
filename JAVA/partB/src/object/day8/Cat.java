package object.day8;

public class Cat extends Animal {
    public static final String TYPE ="고양이 ";
    

    public Cat(String color){
        // super(); //기본 생성자 (부모) 호출 생략 가능
        this.color=color;
    }

    @Override
    public void sound(){
        System.out.println(this.color +" 고양이는 야옹 😽하고 소리를 냅니다. ");
    }

    @Override
    public String toString() {
        return TYPE+"[color=" + color  + "]";
    }
}
