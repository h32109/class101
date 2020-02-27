package store;

import lombok.ToString;


@ToString
public abstract class Product{
    protected int productSeq;
    protected String name;
    protected int price;
    protected int stock;
}
