package object.day6;

public class Cart {
    private String userid;
    private String[] productNames;
    private int[] prices;
    private int total_Money;
    
    
    //total_Money
    public void total_Money(int[] select){
        int sum =0;
        for (int i = 0; i < select.length; i++ ) { 
            int temp =select[i];
            if(temp== -1)break;    
            sum+=prices[temp];
        }
        this.total_Money=sum;
    }//

    public int getTotal_Money(){
        return total_Money;
    }
    
    // public void setTotal_Money(int total_Money){
    //     this.total_Money = total_Money;
    // }

    //Getter Method
    public String getId(){
        return this.userid;
    }
    public String[] getNames(){
        return this.productNames;
    }
    public int[] getPrices(){
        return this.prices;
    }

    
    //Setter Method
    public void setId(String userid){                //id
        this.userid=userid;
    }
    public void setNames(String[] productNames){    //productNames
        this.productNames=productNames;
    }
    public void setPrices(int[] prices){            //prices
        this.prices=prices;
    }
     
}
