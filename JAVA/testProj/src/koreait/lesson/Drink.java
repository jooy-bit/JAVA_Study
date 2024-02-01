package koreait.lesson;
//한주영
public class Drink extends Product{
    //[5]
    public Drink(int price,String prdName){
        super.prdName = prdName;
        super.price = price;
    }

    //[4]
    private boolean isAlcholic;

    public boolean isAlcholic() {
        return isAlcholic;
    }
    public void setAlcholic(boolean isAlcholic) {
        this.isAlcholic = isAlcholic;
    }

    //[7]
    public String buy(){
        if (isAlcholic()==true) {
           return "청소년 구입 가능";
        }else{
            return "청소년 구입 불가";}
        }
     
    //[9]
    public String produce(Object obj){
        return String.format("음료종류[%s] 1set- %d개", this.prdName,obj);
    }


    //[10]
    @Override
    public String toString() {
        return "Drink ["+super.toString()+", isAlcholic=" + isAlcholic + "]";
    }


}
