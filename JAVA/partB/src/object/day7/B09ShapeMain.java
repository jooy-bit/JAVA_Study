package object.day7;

public class B09ShapeMain {
    public static void main(String[] args) {
        Shape square = new Shape("직사각형", 70, 40);
        Triangle semo = new Triangle("세모", 7, 5, 45);


        square.print();
        semo.print();
        System.out.println(square.calculateArea());
        System.out.println(semo.calculateArea());

        //getWidth,getHeight 는 부모클래스 Shape 에서 정의 ,자식이 실행가능

        // square.getAngle(); //부모가 자식 클래스 실행 못함
        //상속에서 변수 참조 타입 - 자식클래스 타입, 부모클래스 타입.
        
        //1)자식 객체를 부모타입으로 참조하기
        Shape tempShape =new Triangle("null", 30, 40, 90);
        tempShape.print();
        
        //2)부모 객체를 자식 타입으로 참조할 수 없음
        // Triangle tempTriangle = new Shape("null", 7, 14);
        
        //3)부모 객체를 자식 타입으로 참조하기 위해 강제캐스팅
        Triangle tempTriangle = (Triangle) new Shape("null", 7, 14);

        //1)과2)에 대해 메소드 사용 제한 확인해보기



    }
}
