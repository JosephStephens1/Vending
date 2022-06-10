package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;

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
				// do purchase
				System.out.println("");
				System.out.println("Current Money Provided: ");
				System.out.println("");
				System.out.println( (1) + " Feed Money");
				System.out.println( (2) + " Select Product");
				System.out.println((3) + " Finish Transaction");

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
