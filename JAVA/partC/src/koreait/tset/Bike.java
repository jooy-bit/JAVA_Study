package koreait.tset;

public class Bike extends Product{
    
    private int speed;

    public Bike (int price,String prdName,int speed){
        super(price, prdName);
        this.speed = speed;
    } //bike
        protected ride(){
            return system.out.print("당신은 이것을 시속 "+speed+"km로 탈 수 있습니다.");
        }
    

    @OverrideS
    public sell(int percent){
        System.out.print(String.format("[%s] 행사 - %d%% 인하",prdName,percent));
    }


    public String toSring(){
        return "[ "+"prdName: "+prdName+", price: "+price+", speed: "+speed+" ]";
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    class Electronics extends Product(){
        @Override
        public String sell(String itemName){
            return System.out.print(String.format("[%s] 증정 - %s",prdName,itemName));
        }

        private double kwh;
        public Electronics (int price,String prdName){
            this. price = price;
            this.prdName = prdName;
        }

        public void power(double kwh){
            return this.kwh*24;
        }

        public void toSring(){
            return "[ "+"prdName: "+prdName+", price: "+price+", kwh: "+kwh+" ]";
        }

        public double getKwh(){
            return this.kwh;
        }

        public void setKwh(double kwh){
            this.kwh = kwh;
        }

}//electronics

}//class