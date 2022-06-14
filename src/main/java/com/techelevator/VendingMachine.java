package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class VendingMachine {

    private BigDecimal currentMoney = new BigDecimal("0.00");

    public static final String ONE = "ONE";
    public static final String FIVE = "FIVE";
    public static final String TEN = "TEN";
    public static final String TWENTY = "TWENTY";

    private String dollarBill;
    Scanner userInput = new Scanner(System.in);
    // private String selectedProductKey;


    private Map<String, VendingItems> items = new HashMap<>();

    Scanner input = new Scanner("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-9\\vendingmachine.csv");

    //  public VendingMachine(String buttonNumber, String itemName, BigDecimal price, String itemType) {
    //    super(buttonNumber, itemName, price, itemType);
    //}

    // Constructor
    public VendingMachine() {

        try (Scanner inventoryInput = new Scanner(new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-9\\vendingmachine.csv"))) {
            while (inventoryInput.hasNextLine()) {
                String currentLine = inventoryInput.nextLine();
                String[] itemList = currentLine.split("\\|");
                String buttonNumber = itemList[0];
                String itemName = itemList[1];
                String price = itemList[2];
                String itemType = itemList[3];


                items.put(buttonNumber, new VendingItems(buttonNumber, itemName, new BigDecimal(price), itemType, 5) {
                    @Override
                    public String getMessage() {
                        return null;
                    }
                });

            }
        } catch (FileNotFoundException ex) {

        }
    }

    public Map<String, VendingItems> getItems() {
        return items;
    }


    //Method MoneyFeed

    // Initialize Money Feed
    public BigDecimal moneyFeed(String dollarBill) {
        BigDecimal balance = new BigDecimal("0.00");

        if (dollarBill.equals(ONE)) {
            balance = new BigDecimal("1.00");
        } else if (dollarBill.equals(FIVE)) {
            balance = new BigDecimal("5.00");
        } else if (dollarBill.equals(TEN)) {
            balance = new BigDecimal("10.00");
        } else if (dollarBill.equals(TWENTY)) {
            balance = new BigDecimal("20.00");
        } else if (dollarBill.equals("1")) {
            balance = new BigDecimal("1.00");
        } else if (dollarBill.equals("5")) {
            balance = new BigDecimal("5.00");
        } else if (dollarBill.equals("10")) {
            balance = new BigDecimal("10.00");
        } else if (dollarBill.equals("20")) {
            balance = new BigDecimal("20.00");
        } else {
            System.out.println("Sorry input not accepted. Please input One, Five, Ten, or Twenty");
        }

        //Adds balance total
        currentMoney = currentMoney.add(balance);
        return currentMoney;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    // Purchase Display Item List
    int updatedQuantity = 5;
    private Map<String, Integer> purchaseTracker = new HashMap<>();



    public String getProductDisplay() {

        System.out.println("");


        for (Map.Entry<String, VendingItems> products : getItems().entrySet()) {
            System.out.println(products.getKey() + " " + products.getValue().getItemName() + " $" + products.getValue().getPrice());
        }

        System.out.println("");
        System.out.print("Please choose a product >>> ");
        String selectedProductKey = userInput.nextLine();




        if (items.containsKey(selectedProductKey) && updatedQuantity >= 0) {
            System.out.println(items.get(selectedProductKey).getItemName() + " $" + items.get(selectedProductKey).getPrice());
            updatedQuantity--;
            if (items.containsKey(selectedProductKey) && updatedQuantity <= 0) {
                System.out.println("SOLD OUT");
            } else {
                System.out.println(updatedQuantity);

                purchaseTracker.put(selectedProductKey, updatedQuantity);
                System.out.println(purchaseTracker);

                if(items.get(selectedProductKey).getItemType().equals("Chip")){  System.out.println("Crunch, Crunch, Crunch!");}
                if(items.get(selectedProductKey).getItemType().equals("Candy")){  System.out.println("Munch, Munch, Mmm-Good!");}
                if(items.get(selectedProductKey).getItemType().equals("Drink")){  System.out.println("Cheers, Glug, Glug!");}
                if(items.get(selectedProductKey).getItemType().equals("Gum")){  System.out.println("Chew, Chew, Pop!");}

            }


        }



        return null;
    }


}







