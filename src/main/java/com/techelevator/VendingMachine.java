package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {

    // Instance Variables
String input = "C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-9\\vendingmachine.csv";

    // Constructor
    public VendingMachine() throws FileNotFoundException {

     try(  Scanner inventoryInput = new Scanner(input)) {
         while (inventoryInput.hasNextLine()) {
             String currentLine = inventoryInput.nextLine();
             System.out.println(currentLine);
         }
     }

    }




}
