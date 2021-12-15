package vendingmachine.view;

import vendingmachine.constant.Message;

public class OutputView {

	public static void printInputVendingMachineCoin() {
		System.out.println(Message.INPUT_VENDING_MACHINE_COIN);
	}

	public static void printException(IllegalArgumentException exception) {
		System.out.println(exception.getMessage());
	}

	public static void printCoinStatus(StringBuilder coinStatus) {
		System.out.println(coinStatus);
	}

	public static void printInputProducts() {
		System.out.println(Message.INPUT_PRODUCTS);
	}
}
