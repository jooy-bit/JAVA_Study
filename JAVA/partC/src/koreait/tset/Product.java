package koreait.tset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public abstract class Product{
    protected int price;
    protected String prdName;
    public abstract String sell (Object odj);
}