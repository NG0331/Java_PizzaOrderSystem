/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yu_ji
 */
public class Pizza {
   private int[] Topping=new int[3];
   private int size;
   private int price;
   public void addPrice(int addedPrice){
    this.price+=addedPrice;
}
   public int getPrice(){
       return price;
   }
   public void setSize(int size){
       this.size=size;
       switch(size){
           case 1:
                    addPrice(8);
                    break;
           case 2:
                    addPrice(10);
                    break;
           case 3:
                   addPrice(12);
                   break;
        }
   }
   public void addTopping(int which){
       Topping[which]=1;
       this.addPrice(2);
   }
   
}
