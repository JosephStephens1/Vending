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

public class VendingMachine {

private Map<String,VendingItems> items = new HashMap<>();

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



                items.put(buttonNumber,new VendingItems(buttonNumber,itemName, new BigDecimal (price),itemType,  5));

            }
        }
        catch (FileNotFoundException ex){

        }
    }
  public Map<String, VendingItems> getItems(){
        return items;
  }

}






