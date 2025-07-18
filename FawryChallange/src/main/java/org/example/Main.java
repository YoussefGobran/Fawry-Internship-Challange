package org.example;

import java.util.Date;

public class Main {
    public  static Date  today = new Date(2025,7,5);

    public static void main(String[] args) {
        Product TV = new Product("Tv",25,50,3000,true);
        Product milk = new Product("milk",10,100,50,true,new Date(2025,8,12));

        //best case scenario
        Customer ahmed = new Customer("ahmed" , 250 , "Masr Elgdida");
        Cart ahmedCart = new Cart(ahmed);
        ahmedCart.addProduct(TV,5);
        ahmedCart.addProduct(milk,2);
        System.out.println( ahmedCart.Checkout());

        //case of non sufficent funds
        Customer mohamed = new Customer("mohamed" , 20 , "Tagmo3");
        Cart mohamedCart = new Cart(mohamed);
        mohamedCart.addProduct(TV,5);
        System.out.println( mohamedCart.Checkout());

        //case of non sufficent product amount
        Customer MOCK = new Customer("MOCK" , 100000 , "Tagmo3");
        Cart mockCart = new Cart(MOCK);
        mohamedCart.addProduct(TV,50);
        System.out.println( mockCart.Checkout());

        //case of expiration
        milk.setExpiryDate(new Date(2024,8,12));
        mohamedCart.addProduct(milk,50);
        System.out.println( mockCart.Checkout());







    }
}