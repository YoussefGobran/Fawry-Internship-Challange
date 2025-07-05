package org.example;

import java.util.Date;

public class Product {
    private String name ;
    private double price;
    private int quantity;
    private float weight;
    private boolean shippable;
    private boolean expirable ;
    private Date expiryDate;

    public Product(String name, double price, int quantity, float weight, boolean shippable)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.shippable = shippable;
        this.expirable = false;
        this.expiryDate = null;
    }

    public Product(String name, double price, int quantity, float weight, boolean shippable, Date expiryDate)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.shippable = shippable;
        this.expirable = true;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isShippable() {
        return shippable;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public boolean isExpirable() {
        return expirable;
    }

    public void setExpirable(boolean expirable) {
        this.expirable = expirable;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean takeQuantity(int q)
    {
        if(this.quantity == 0)
        {
            System.out.println("the product "+ this.name +" is out of stock");
            return false;
        }
        if(q>this.quantity)
        {
            System.out.println("the product "+ this.name +" has less amount in the stock");
            return false;
        }
        if(this.expirable)
        {
            if(this.expiryDate.before(Main.today))
            {
                System.out.println("the product "+ this.name +" is Expired ");
                return false;
            }
        }
        this.quantity -= q;
        return true;
    }

}
