package object.day8;

public class B15AbstactTest {
    public static void main(String[] args) {
        // Animal cat = new Animal(); //new 객체 생성 못합니다. 이유: 추상클래스

        //Anonymous(익명) Inner(내부클래스) 타입 : 클래스 이름이 없는 내부 클래스 형식
        Animal animal = new Animal() {
            @Override
            public void sound(){
                System.out.println("익명으로 만들어진 동물 클래스");
            }
        };

        
        animal.sound();
        System.out.println("animal toString= "+animal);

        Puppy puppy = new Puppy("푸들이","브라운");
        puppy.sound();
        System.out.println("puppy toString= "+puppy);


    }

}
