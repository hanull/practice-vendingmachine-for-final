package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;

public class InputView {

	private static String input() {
		return Console.readLine();
	}

	public static Money InputVendingMachineCoin() {
		return new Money(input());
	}

	public static Products InputProducts() {
		String inputProducts = input();
		return Products.createProducts(inputProducts);
	}

	public static Money InputUserMoney() {
		return new Money(input());
	}
}
