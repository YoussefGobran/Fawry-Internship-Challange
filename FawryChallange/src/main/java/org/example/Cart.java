package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cart {
    Customer cartOwner;
    HashMap <Product , Integer> shoppingList ;
    List<Product> productList ;

    public Cart(Customer customer) {
        this.shoppingList = new HashMap<>();
        this.productList = new LinkedList<>();
        this.cartOwner = customer;
    }

    public boolean addProduct (Product product , int quantity)
    {
        if(product.takeQuantity(quantity))
        {
            shoppingList.put(product,quantity);
            productList.add(product);
            return true;
        }

        return false;
    }

     public String Checkout()
     {
         if (this.productList.isEmpty())
         {
             return "Cart Is empty";
         }

         double subTotal = 0;
         double shipping = 0;
         double total = 0; //subTotal + shipping

         boolean shippingFlag = false;
         List <Product> shippingList = null;

         for(Product product : this.productList)
         {
             subTotal += (this.shoppingList.get(product) * product.getPrice());

             if(product.isShippable())
             {
                 if(shippingFlag == false)
                 {
                     shippingList = new LinkedList<>();
                     shipping = 30; //fixed cost
                 }
                 shippingFlag = true;
                 shippingList.add(product);
             }

         }
         //shipping calculator

         if(shippingFlag == false)
         {
             total = subTotal ;
         }
         else
         {
             total = subTotal + shipping;
         }

         if(total > cartOwner.getBalance())
         {
             return "Customer's balance is insufficient.";
         }
         //send shipping list to shipping service
         return printNotice(subTotal,shipping,total);
     }

     private String printNotice(double subTotal,double shipping,double total)
     {
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append("** Shipment notice ** \n");

         float totalWeight = 0;
         for(Product product : this.productList)
         {
             stringBuilder.append(shoppingList.get(product));
             stringBuilder.append("x " + product.getName() + "\t");
             stringBuilder.append(shoppingList.get(product) * product.getWeight());
             totalWeight += shoppingList.get(product) * product.getWeight();
             stringBuilder.append("g \n");
         }
         stringBuilder.append("Total package weight  ");
         stringBuilder.append(totalWeight/1000);
         stringBuilder.append("kg \n");

         stringBuilder.append("** Checkout receipt ** \n");
         for(Product product : this.productList)
         {
             stringBuilder.append(shoppingList.get(product));
             stringBuilder.append("x " + product.getName() + "\t");
             stringBuilder.append((this.shoppingList.get(product) * product.getPrice()));
             stringBuilder.append("\n");
         }
         stringBuilder.append("---------------------- \n");
         stringBuilder.append("SubTotal \t");
         stringBuilder.append(subTotal);
         stringBuilder.append("\n");
         stringBuilder.append("Shipping \t");
         stringBuilder.append(shipping);
         stringBuilder.append("\n");
         stringBuilder.append("Amount \t");
         stringBuilder.append(total);
         stringBuilder.append("\n");

         return stringBuilder.toString();
     }
}
