package project.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerByVo {
    
    private String buy_Idx;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp buy_Date;
    
    @Override
    public String toString(){
        return String.format("%8d %-15s %-40s\t %6d %4d %30s", buy_Idx,pcode,pname,price,quantity,buy_Date);
    }

    
}
