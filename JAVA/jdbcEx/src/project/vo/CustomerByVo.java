package project.vo;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class CustomerByVo {
    
    private String buy_Idx;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp buy_Date;

}
