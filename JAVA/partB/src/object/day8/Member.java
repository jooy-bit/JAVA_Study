package object.day8;

public class Member{
    private String name;
    private int age;

    public Member(int age, String name){
        this.name = name;
        this.age = age;
    }

//다형성 예시: 메소드 인자 -부모일 경우, 실제 객체(실행시 결정, 정의된 시기엔 알 수 없음)는 여러 자식 객체가 될 수 있다.
    public boolean isAdopt(Animal animal){
        //and 연산 특징 : 참&&참 = 참 / 참&&거짓= 거짓 / 거짓&&참 = 거짓 / 거짓&&거짓 = 거짓
        //or 연산 특징 : 참&&참 = 참 / 참&&거짓= 참 / 거짓&&참 = 참 / 거짓&&거짓 = 거짓
        if (animal instanceof Puppy&&this.age >=15) return true;
        else if(animal instanceof Cat&&this.age >=18)return true;
        else if (animal instanceof Rabbit&&this.age>=13) return true;
        else if (this.age>=20) return true;
        else return false;
    }

    public String getName(){
        return this.name;
    }

 
    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }
    
        
}//



