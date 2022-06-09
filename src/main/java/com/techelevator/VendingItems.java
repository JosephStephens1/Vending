package com.techelevator;

import java.math.BigDecimal;

public class VendingItems  {

    private String buttonNumber;
    private String itemName;
    private BigDecimal price;
    private String itemType;
    private int quantity = 5;




    public String getButtonNumberNumber(){
        return buttonNumber;
    }

    public void setButtonNumber(String buttonNumber){
        this.buttonNumber = buttonNumber;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getItemType(){
        return itemType;
    }

    public void setItemType(String itemType){
        this.itemType = itemType;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public VendingItems( String buttonNumber, String itemName,BigDecimal price,String itemType, int quantity){
        this.buttonNumber = buttonNumber;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
       this.quantity = quantity;
    }







}
  //