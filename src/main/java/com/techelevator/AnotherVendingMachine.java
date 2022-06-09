
 package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

    public class AnotherVendingMachine {

        // constants
        public static final String CHIPS = "Chips";
        public static final String CANDY = "Candy";
        public static final String GUM = "Gum";
        public static final String DRINK = "Drink";

        private String slotLocation;
        private String itemName;
        private String itemType;


        public AnotherVendingMachine(String slotLocation, String itemName, String itemType) {
            this.slotLocation = slotLocation;
            this.itemName = itemName;
            this.itemType = itemType;

        }

        //methods:
        //access modifier, return data type, the name of the method, and parentheses that
        //will include any parameters that we are passing in
        public String getItemName() {
            return itemName;
        }

        public String getItemType() {
            return itemType;
        }

        public String getSlotLocation() {
            return slotLocation;
        }

        public BigDecimal getRentalPrice() {

            // There are a couple ways to initialize big decimal
            BigDecimal itemPrice = new BigDecimal("0.00");
            //BigDecimal price = BigDecimal.valueOf(3.5);

            if(itemType.equals(CHIPS)) {
                itemPrice = new BigDecimal("0.99");
            } else if (itemType.equals(GUM)) {
                itemPrice = new BigDecimal("2.99");
            } else if(itemType.equals(CANDY)) {
                itemPrice = new BigDecimal("1.99");
            }
            else if(itemType.equals(DRINK)) {
                itemPrice = new BigDecimal("1.99");
            }



            return itemPrice;

            // EXAMPLE: force how many decimals to keep (2) and how to round
            // return price.setScale(2, RoundingMode.UP);
        }

        public BigDecimal getLateFee(int daysLate) {
            BigDecimal lateFee = new BigDecimal("0.00");

            if(daysLate == 0) {
                //do nothing
            } else if (daysLate == 1) {
                lateFee = new BigDecimal("1.99");
            } else if(daysLate ==2) {
                lateFee = new BigDecimal("3.99");
            } else if (daysLate >= 3) {
                lateFee = new BigDecimal("19.99");
            }

            return lateFee;
        }

        @Override
        public String toString() {
            return "MOVIE - " + itemName + " - " + itemType + " " + getRentalPrice();
        }

    }




