package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingItems {
    @Override
    public String getMessage() {
        return "Munch Munch, Mmmm-Good!";
    }

    public Candy(String buttonNumber, String itemName, BigDecimal price, String itemType, int quantity) {
        super(buttonNumber, itemName, price, itemType, quantity);
    }
}
