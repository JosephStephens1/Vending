package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {



    // Constructor
    public static void main(String[] args) throws FileNotFoundException {

     try( Scanner inventoryInput = new Scanner("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-9\\vendingmachine.csv"))
     {
         while (inventoryInput.hasNextLine())
         {
             String currentLine = inventoryInput.nextLine();
             String[] itemList = currentLine.split("|");
             String buttonNumber = itemList[0];
             String itemName = itemList[1];
             String price = itemList[2];
             String itemType = itemList[3];
            // String quantityNumber = itemList[4];
         }


     }


    }




}
