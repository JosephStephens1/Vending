package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;
	List<String> purchasedItemTracker = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		System.out.println("");
		System.out.println("Welcome to the Umbrella Corp. Vendo-Matic 800");

		VendingMachine vendingMachine = new VendingMachine();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				for(Map.Entry<String, VendingItems> products: vendingMachine.getItems().entrySet()){
					System.out.println(products.getKey() + " " +  products.getValue().getItemName() + " $" + products.getValue().getPrice() + " Items Remaining: " + products.getValue().getQuantity() );

				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				vendingMachine.getProductDisplay();


				String wantMore = "Y";
				// do purchase
				do {
					System.out.println("");
					System.out.println("Current Money Provided: " + vendingMachine.getCurrentMoney());
					System.out.println("");
					System.out.println("1)" + " Feed Money");
					System.out.println("2)" + " Select Product");
					System.out.println("3)" + " Finish Transaction");
					System.out.println(" ");
					System.out.print("Please choose an option >>> ");

					// Get User Input
					Scanner userInput = new Scanner(System.in);
					String transactionChoice = userInput.nextLine();

					if (transactionChoice.equals("1")) {
						System.out.println("Please input money:  ONE , FIVE , TEN , TWENTY ");
						String feedMoney = userInput.nextLine().toUpperCase();


						vendingMachine.moneyFeed(feedMoney.toUpperCase());
						System.out.println("New Balance is " + vendingMachine.getCurrentMoney());

					} else if (transactionChoice.equals("2")) {

						vendingMachine.getProductDisplay();

					} else if (transactionChoice.equals("3")) {

					}
					else{
						System.out.println("Please enter a valid choice!");}

					System.out.println("Do you want to make another purchase? (Y/N)");
					wantMore = userInput.nextLine();

				} while(wantMore.equalsIgnoreCase("Y"));
			}
		}

	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		AnotherVendingMachineCLI cli = new AnotherVendingMachineCLI(menu);
		cli.run();
	}
}