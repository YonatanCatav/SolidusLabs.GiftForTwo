package com.soliduslabs;

public class Item {
    String Name;
    int Price;
    public Item(String Name,int Price)
    {
        this.Name=Name;
        this.Price=Price;
    }
    public int getPrice()
    {
        return Price;
    }
    public String getName()
    {
        return Name;
    }
}
