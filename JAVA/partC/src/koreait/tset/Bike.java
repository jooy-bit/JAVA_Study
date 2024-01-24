package koreait.tset;

public class Bike extends Product{
    private int speed;

    public Bike (int price,String prdName,int speed){
        this. price = price;
        this.prdName = prdName;
        this.speed = speed;
        class ride(){
            return system.out.print("당신은 이것을 시속 "+speed+"km로 탈 수 있습니다.");
        }
    }  

    @Override
    public sell(int percent){
        return system.out.print(String.format("[%s] 행사 - %d%% 인하",prdName,percent));
    }


    public void toSring(){
        return "[ "+"prdName: "+prdName+", price: "+price+", speed: "+speed+" ]";
    }
}

public int getPrice(){
    return this.price;
}

public void setPrice(int price){
    this.price = price;
}

class Electronics extends Product(){
    @Override
    public sell(String itemName){
        return system.out.print(String.format("[%s] 증정 - %s",prdName,itemName));
    }

    private double kwh;
    public Electronics (int price,String prdName){
        this. price = price;
        this.prdName = prdName;
    }

    public power(){
        return kwh*24;
    }
}
public void toSring(){
    return "[ "+"prdName: "+prdName+", price: "+price+", kwh: "+kwh+" ]";
}

public double getKwh(){
    return this.getKwh;
}

public void setKwh(double kwh){
    this.kwh = kwh;
}
