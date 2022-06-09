package com.techelevator;

import java.math.BigDecimal;

public class Drink extends VendingItems {
    public Drink(String buttonNumber, String itemName, BigDecimal price, String itemType, int quantity ) {
        super(buttonNumber, itemName, price, itemType, quantity);
    }

}
