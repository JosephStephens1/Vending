package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingItems{
    @Override
    public String getMessage() {
        return "Chew Chew, Pop!";
    }

    public Gum(String buttonNumber, String itemName, BigDecimal price, String itemType, int quantity) {
        super(buttonNumber, itemName, price, itemType,quantity);
    }
}
