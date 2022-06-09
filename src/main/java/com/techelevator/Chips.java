package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingItems  {


    public Chips(String buttonNumber, String itemName, BigDecimal price, String itemType, int quantity) {
        super(buttonNumber, itemName, price, itemType,quantity);
    }
}
