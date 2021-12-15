package vendingmachine.view;

import vendingmachine.constant.Constant;
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

	public static void printInputUserMoney() {
		printNewLine();
		System.out.println(Message.INPUT_USER_MONEY);
	}

	public static void printInputSelectProduct() {
		System.out.println(Message.INPUT_SELECT_PRODUCT);
	}

	public static void printUserMoneyStatus(int userMoney) {
		printNewLine();
		System.out.println(Message.CHECK_USER_MONEY + userMoney + Constant.WON);
	}

	private static void printNewLine() {
		System.out.println();
	}

	public static void printVendingMachineCoin() {
		printNewLine();
		System.out.println(Message.VANDING_MACHINE_COIN_STATUS);
	}

	public static void printChanges() {
		System.out.println(Message.CHANGES);
	}
}
