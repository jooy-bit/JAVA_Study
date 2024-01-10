package object.day8.day8_interface.beable;

public class Dog implements Runnable{

    @Override
    public String beAble() {
        return null;
    }

    @Override
    public String run(int speed){
        return "개는" + speed + "Km/h로 달립니다\n 최대속도 50Km/h입니다.";
    }
    
}
