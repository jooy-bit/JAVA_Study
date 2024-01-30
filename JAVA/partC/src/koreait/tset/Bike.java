package koreait.tset;
public class Bike extends Product{
    
    private int speed;

    public Bike (int price,String prdName,int speed){
        super(price,prdName);
        this.speed = speed;
    } //bike
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected String ride(){
        return "당신은 이것을 시속 "+speed+"km로 탈 수 있습니다.";
    }

    @Override
    public String sell(Object obj){
        return String.format("[%s]행사 -%d%% 인하", prdName, obj);
    }
    @Override
    public String toString() {
        return "Bike [" + super.toString() + ", speed=" + speed + "]";
    }




class Electronics extends Product{
    public Electronics (int price,String prdName){
        super(price,prdName);
    }
    public String sell(Object obj){
        return String.format("[%s]증정- %s", this.prdName,obj);
    }
    public double power(){
        return this.kwh*24;
    }
    
    private double kwh;
    public Electronics(int price, String prdName, double kwh) {
        super(price, prdName);
        this.kwh = kwh;
    }
    @Override
    public String toString(){
            return "Electronics [ ,"+super.toString()+", kwh="+  kwh + "]";
        }

    public double getKwh(){
            return this.kwh;
    }

    public void setKwh(double kwh){
            this.kwh = kwh;
    }

    

}//electronics

}//class