package koreait.tset;

public class Bike extends Product{
    
    private int speed;
    private int price;

    public Bike (int price,String prdName,int speed){
        this.prdName = prdName;
        this.price =price;
        this.speed = speed;
    } //bike
    public int getSpeed() {
        return speed;
    }

    protected String ride(int speed){
        return "당신은 이것을 시속 "+speed+"km로 탈 수 있습니다.";
    }

    @Override
    public String sell(Object obj){
        int discount = (int) obj;
        return String.format("[%s]행사 -%d%% 인하", prdName, discount);
    }
    @Override
    public String toString() {
        return "Bike [price=" + price + ", prdName=" + prdName + ", speed=" + speed + "]";
    }




public class Electronics extends Product{
    private double kwh;
    private int price;
    
    public Electronics (int price,String prdName){
        this.price = price;
        this.prdName = prdName;
    }

        public double power(double kwh){
            return this.kwh*24;
        }

        public String toSring(){
            return "Electronics [price=" + price + ", prdName=" + prdName + ", kwh=" + kwh + "]";
        }

        public double getKwh(){
            return this.kwh;
        }

        public void setKwh(double kwh){
            this.kwh = kwh;
        }

}//electronics

}//class