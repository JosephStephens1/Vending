package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		VendingMachine vendingMachine = new VendingMachine();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				for(Map.Entry<String, VendingItems> products: vendingMachine.getItems().entrySet()){
					System.out.println(products.getKey() + " " +  products.getValue().getItemName() + " $" + products.getValue().getPrice() + " Items Remaining: " + products.getValue().getQuantity() );

				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// Initialize Money Feed
				BigDecimal balance = new BigDecimal( "0.00");


				// do purchase
				System.out.println("");
				System.out.println("Current Money Provided: " + balance);
				System.out.println("");
				System.out.println( "1)" + " Feed Money");
				System.out.println( "2)" + " Select Product");
				System.out.println( "3)" + " Finish Transaction");

				// Get User Input
				Scanner userInput = new Scanner(System.in);
				String transactionChoice = userInput.nextLine();

				if(transactionChoice == "1")
				{
					System.out.println("Please input money");
					String feedMoney = userInput.nextLine();
					balance = new BigDecimal(feedMoney);
				}
				else if( transactionChoice == "2")
				{
					System.out.println("Select item");
				}
				else if( transactionChoice == "3")
				{

				}
				else
				{
					System.out.println("Please enter a valid choice!");
				}

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
