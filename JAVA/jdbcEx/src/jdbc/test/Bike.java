package jdbc.test;

public class Bike extends Product{

    private int speed;
    
    public Bike(String prdName,int price,int speed) {
        super();
        this.prdName = prdName;
        this.price = price;
        this.speed = speed;
    }
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    @Override
    public String sell(Object obj) {
        return String.format("[%s] 행사 - %d%% 인하", prdName,obj);
    }

    public String ride(){
        return String.format("당신은 이것을 시속 %dkm로 탈 수 있습니다", this.speed);
    }
    
    @Override
    public String toString() {
        return "Bike ["+super.toString()+",speed=" + speed + "]";
    }


    class ELectronics extends Product{
        
        public ELectronics(int price, String prdName) {
            //super();
            this.prdName= prdName;
            this.price = price;
        }
            
        @Override
        public String sell(Object obj) {
            return String.format("[%s] 증정 -%s", prdName,obj);
        }
        
        private double kwh;
        
        public double getKwh() {
            return this.kwh;
        }
        public void setKwh(double kwh) {
            this.kwh = kwh;
        }
        public double power(){
            return this.kwh*24;
        }
        
        @Override
        public String toString() {
            return "Electonics ["+super.toString()+",kwh=" + kwh + "]";
        }
        
    }
}
