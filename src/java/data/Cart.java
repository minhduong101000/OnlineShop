/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public final class Cart {
 private List<Item> items;
 
 public Cart(){
     items= new ArrayList<>();
 }
 
 public List<Item>getItems(){
     return items;
 }
 
 public int getQuantityById(String id){
     return getItemById(id).getQuantity();
 }
 
 public Item getItemById(String id){
     for(Item i:items){
         if(i.getProduct().getID() == null ? id == null : i.getProduct().getID().equals(id)){
             return i;
         }
     }
     return null;
 }
 
 public void addItem(Item t){
     if(getItemById(t.getProduct().getID())!=null){
         Item m= getItemById(t.getProduct().getID());
         m.setQuantity(m.getQuantity()+t.getQuantity());
     }else{
         items.add(t);
     } 
 }
 
public void removeItem (String id){
    if(getItemById(id)!=null){
        items.remove(getItemById(id));
    }
}

public double getTotalMoney(){
    double t=0;
    for(Item i:items){
        t+=(i.getQuantity()*i.getPrice());
    }
    return t;
}

private Products getProductByIdd(String id, List<Products> list){
    for(Products i:list ){
        if(i.getID() == null ? id == null : i.getID().equals(id)){
            return i;
        }
    }
    return null;
}

public Cart(String txt,List<Products> list){
    items= new ArrayList<>();
    try{
    if(txt!=null && txt.length()!=0){
        String[]s=txt.split(",");
        for(String i:s){
            String[] n=i.split(":");
            String id = n[0];
            int quantity = Integer.parseInt(n[1]);
            Products p=getProductByIdd(id, list);
            Item t = new Item(p, quantity, p.getPrice());
            addItem(t);
        }
    }
    }catch(Exception e){
        System.out.println(e);
    }
}

}
