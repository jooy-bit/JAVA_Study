package koreait.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public abstract class Product {
    protected int price;
    protected String prdName;   // 1 - [1]
    public abstract String sell(Object object); // 1 - [2]    
    }

