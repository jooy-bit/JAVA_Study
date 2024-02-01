package test;

public class Bike extends Product{

    private int speed;
    public Bike(int price,String prdName, int speed){
        super(price, prdName);// Product 클래스의 생성자 호출
        this.speed = speed;
    }

    public String ride(){
        return String.format("당신은 이것을 시속 %dkm 로 탈 수 있습니다", speed);
    }

    
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String sell(Object obj){
        return String.format("[%s] 행사- %d%% 인하", prdName,obj);
    }// prdName 대신 getPrdName()을 사용하여 오류 수정
    

    @Override
    public String toString() {
        return "Bike ["+super.toString()+", speed=" + speed + "]";
    }

}
class ELectronics extends Product{
    private double kwh;
    
    public ELectronics(int price,String prdName){
        super(price, prdName);
        super.prdName = prdName;
        super.price = price;
    }

    public double getKwh() {
        return kwh;
    }
    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double power(){
        return kwh*24;
    }

    @Override
    public String sell(Object obj){
        return String.format("[%s] 증정- %s", prdName,obj);
    }// prdName 대신 getPrdName()을 사용하여 오류 수정

    @Override
    public String toString() {
        return "ELectronics ["+super.toString()+", kwh=" + kwh + "]";
    }

    
}
