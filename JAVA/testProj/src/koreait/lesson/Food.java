package koreait.lesson;
//한주영
public class Food extends Product{
    //[3]
    private int kcal;
    public int getKcal() {
        return kcal;
    }
    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    //[5]
    public Food(int price,String prdName, int kcal){
        super.prdName = prdName;
        super.price = price;
        this.kcal = kcal;
    }

    //[6]
    public double intake(double kg){
        return kcal/(kg*30)*100;
    }

    //[8]
    public String produce(Object obj){
        return String.format("[%s]생산지-%s", this.prdName,obj);
    }
    //[10]
    @Override
    public String toString() {
        return "Food ["+super.toString()+", kcal=" + kcal + "]";
    }

    

}
